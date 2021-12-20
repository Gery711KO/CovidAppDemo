package hu.kocsisgeri.bitraptors.data.repository

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import hu.kocsisgeri.bitraptors.data.scrapper.WebScrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

class CovidRepository(
    override val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val dao: PersonDao,
    private val webScrape: WebScrapper,
) : CoroutineScope {
    fun getCovidList(): Flow<ApiResult<List<Person>>> = flow {
        var index = 0
        val isCacheOutdated = dao.getData().size != webScrape.getMaxId()?.toInt()
        val lastPage = webScrape.getLastPage()

        dao.getData().let { cache ->
            if (isCacheOutdated) {
                val firstCacheId = dao.getData().minByOrNull { y -> y.id }?.id ?: 0
                while(index <= lastPage)
                {
                    val web = webScrape.getDataFromWeb(index)
                    if (web.any{ x -> x.id < firstCacheId})
                    {
                        dao.insertAll(web)
                    } else break
                    emit(ApiResult.Progress(index / lastPage))
                    index++
                }
                emit(ApiResult.Success(dao.getData()))
            } else emit(ApiResult.Success(cache))
        }
    }

    fun getDatabaseSize() : Flow<Int> = flow {
        val size = dao.getData().size
        emit(size)
    }

    fun getCovidVaccinated() :Flow<String?> = flow {
        val vaccinatedNum = webScrape.getVaccinated()
        emit(vaccinatedNum)
    }

    fun getCovidMaxId() :Flow<String?> = flow {
        val maxId = webScrape.getMaxId()
        emit(maxId)
    }
}