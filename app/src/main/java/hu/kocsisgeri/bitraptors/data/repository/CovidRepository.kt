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
    fun getCovidList(): Flow<List<Person>> = flow {
        var index = 0
        dao.getData().let { cache ->
            if (cache.isEmpty()) {
                while(index <= webScrape.getLastPage())
                {
                    val web = webScrape.getDataFromWeb(index)
                    if (index == 0){
                        dao.insertAll(web)
                        emit(web)
                    }
                    else{
                        dao.insertAll(web)
                    }
                    index++
                }
                emit(dao.getData())
            }else if (cache.size != webScrape.getMaxId()?.toInt()) {
                emit(cache.subList(cache.size-50, cache.size))
                while(index <= webScrape.getLastPage())
                {
                    getDatabaseSize()
                    val web = webScrape.getDataFromWeb(index)
                    if (web.minOf { x -> x.id } < dao.getData().minOf { y -> y.id })
                    {
                        dao.insertAll(web)
                    }
                    index++
                }
                emit(dao.getData())
            } else emit(cache)
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