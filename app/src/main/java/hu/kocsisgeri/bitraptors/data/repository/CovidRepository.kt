package hu.kocsisgeri.bitraptors.data.repository

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.dao.PersonDao
import hu.kocsisgeri.bitraptors.data.scrapper.WebScrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext

class CovidRepository(
    override val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val dao: PersonDao,
    private val webScrape: WebScrapper,
) : CoroutineScope {

    fun getCovidList(): Flow<List<Person>> = flow {
        val data = dao.getData().let { cache ->
            if (cache.isEmpty()) {
                val web = webScrape.getDataFromWeb()
                dao.insertAll(web)
                web
            } else cache
        }
        emit(data)
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