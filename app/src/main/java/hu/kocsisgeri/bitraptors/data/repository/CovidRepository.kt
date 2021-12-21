package hu.kocsisgeri.bitraptors.data.repository

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import hu.kocsisgeri.bitraptors.data.logic.Filter
import hu.kocsisgeri.bitraptors.data.logic.WebScrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext
import kotlin.math.roundToInt

class CovidRepository(
    override val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val dao: PersonDao,
    private val webScrape: WebScrapper,
) : CoroutineScope {
    val filter = MutableStateFlow<Filter>(Filter(null,null,null))

    fun getCovidList(): Flow<ApiResult<List<Person>>> = flow {
        var index = 0
        val isMaxFound = dao.getData().maxOfOrNull{x -> x.id}?: 0 != webScrape.getMaxId()?.toInt()
        val isMinFound = dao.getData().minOfOrNull{x -> x.id}?: 0 != 1
        val lastPage = webScrape.getLastPage().toDouble()

        dao.getData().let { cache ->
            if (isMinFound && isMaxFound) {
                val firstCacheId = dao.getData().minByOrNull { y -> y.id }?.id ?: 0
                val lastCacheId = dao.getData().maxByOrNull { x -> x.id }?.id ?: 0
                while (index <= lastPage) {
                    val web = webScrape.getDataFromWeb(index)

                    if (web.any { x -> x.id > firstCacheId }) {
                        dao.insertAll(web)
                    } else if (web.any { x -> x.id > lastCacheId }) {
                        dao.insertAll(web)
                    } else break

                    emit(ApiResult.Progress(((index / lastPage) * 100).roundToInt()))
                    index++
                }
                emit(ApiResult.Success(dao.getData().subList(dao.getData().size-100, dao.getData().size).sortedByDescending { x -> x.id }))
            } else emit(ApiResult.Success(cache.subList(cache.size-100, cache.size).sortedByDescending { x -> x.id }))
        }
    }.flatMapLatest { halottak -> filter.map{
        if(halottak is ApiResult.Success){
            halottak.copy(it.getFilteredList(halottak.data))
        }else halottak
    }
    }

    fun getDatabaseSize(): Flow<Int> = flow {
        val size = dao.getData().size
        emit(size)
    }

    fun getCovidVaccinated(): Flow<String?> = flow {
        val vaccinatedNum = webScrape.getVaccinated()
        emit(vaccinatedNum)
    }

    fun getCovidMaxId(): Flow<String?> = flow {
        val maxId = webScrape.getMaxId()
        emit(maxId)
    }
}