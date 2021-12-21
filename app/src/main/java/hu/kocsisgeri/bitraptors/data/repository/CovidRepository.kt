package hu.kocsisgeri.bitraptors.data.repository

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import hu.kocsisgeri.bitraptors.data.scrapper.WebScrapper
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
    fun getCovidList(): Flow<ApiResult<List<Person>>> = flow {
        var index = 0
        val isMaxFound = dao.getData().maxOf{x -> x.id} != webScrape.getMaxId()?.toInt()
        val isMinFound = dao.getData().minOf{x -> x.id} != 1
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