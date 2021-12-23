package hu.kocsisgeri.bitraptors.data.repository

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import hu.kocsisgeri.bitraptors.data.logic.Filter
import hu.kocsisgeri.bitraptors.data.logic.WebScrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlin.coroutines.CoroutineContext
import kotlin.math.roundToInt

class CovidRepository(
    override val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val dao: PersonDao,
    private val webScrape: WebScrapper,
) : CoroutineScope {
    val filter = MutableStateFlow<Filter>(Filter(null, null, null))
    val refresh = MutableSharedFlow<Unit>(0, 100)

    fun getCovidList(): Flow<ApiResult<List<Person>>> = refresh.flatMapLatest { flow {
        try {
            var index = 0
            val isMaxFound =
                dao.getData().maxOfOrNull { x -> x.id } ?: 0 == webScrape.getMaxId()?.toInt()
            val isMinFound = dao.getData().minOfOrNull { x -> x.id } ?: 0 == 1
            val lastPage = webScrape.getLastPage().toDouble()

            dao.getData().let { cache ->
                if (!isMinFound || !isMaxFound) {
                    val firstCacheId = dao.getData().minByOrNull { y -> y.id }?.id ?: 0
                    val lastCacheId = dao.getData().maxByOrNull { x -> x.id }?.id ?: 0
                    while (index <= lastPage) {
                        val web = webScrape.getDataFromWeb(index)

                        if (web.any { x -> x.id > lastCacheId }
                            || web.any { x -> x.id < firstCacheId }) {
                            dao.insertAll(web)
                        } else if (firstCacheId != 1) {
                            dao.insertAll(web)
                        } else break

                        emit(ApiResult.Progress(((index / lastPage) * 100).roundToInt()))
                        index++
                    }
                    emit(
                        ApiResult.Success(dao.getData())
                    )
                } else emit(
                    ApiResult.Success(cache)
                )
            }
        } catch (exception: Exception) {
            emit(ApiResult.Error(exception.message!!))
        }
    }.flatMapLatest { halottak ->
        filter.map {
            if (halottak is ApiResult.Success) {
                halottak.copy(it.getFilteredList(halottak.data.sortedByDescending { x -> x.id }))
            } else halottak
        }
    } }

    fun getCovidVaccinated(): Flow<ApiResult<String>> = refresh.flatMapLatest { flow {
        try {
            val vaccinatedNum = webScrape.getVaccinated()
            emit(ApiResult.Success(vaccinatedNum))
        } catch (exception: Exception) {
            emit(ApiResult.Error(exception.message!!))
        }
    }}

    fun getCovidMaxId(): Flow<ApiResult<String>> = refresh.flatMapLatest { flow {
        try {
            val maxId = webScrape.getMaxId()
            emit(ApiResult.Success(maxId))
        } catch (exception: Exception) {
            emit(ApiResult.Error(exception.message!!))
        }
    }}
}