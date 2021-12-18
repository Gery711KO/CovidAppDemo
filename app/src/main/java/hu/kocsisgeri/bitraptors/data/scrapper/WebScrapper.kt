package hu.kocsisgeri.bitraptors.data.scrapper

import hu.kocsisgeri.bitraptors.data.dao.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class WebScrapper {
    suspend fun getDataFromWeb() : List<Person> = withContext(Dispatchers.IO) {
            Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get().let { document ->
                val lastPage = document.getElementsByAttributeValue("class", "pager-last")
                    .last()?.child(0)?.attr("href")
                    .toString().split("=")[1].toInt()

                document.select("tbody").firstOrNull()?.children()?.map { element ->
                    Person(
                        element.child(0).text().toInt(),
                        element.child(1).text(),
                        element.child(2).text().toInt(),
                        element.child(3).text()
                    )
                } ?: emptyList()
            }
        }

    suspend fun getVaccinated() : String? = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu").get().getElementsByAttributeValue("id", "api-beoltottak").firstOrNull()?.text()
    }

    suspend fun getMaxId() : String? = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get().getElementsByAttributeValue("class", "views-field views-field-field-elhunytak-sorszam").get(1).text()
    }

    }
