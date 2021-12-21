package hu.kocsisgeri.bitraptors.data.logic

import hu.kocsisgeri.bitraptors.data.dao.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class WebScrapper {
    suspend fun getDataFromWeb(index: Int): List<Person> = withContext(Dispatchers.IO) {
        val doc = Jsoup.connect("https://koronavirus.gov.hu/elhunytak?page=$index").get()
        val children = doc.select("tbody").firstOrNull()?.children()

        children?.map { element ->
            Person(
                element.child(0).text().toInt(),
                element.child(1).text().let{
                    if (it.lowercase() != "férfi") {
                        "Nő"
                    }else "Férfi"
                }.toString(),
                element.child(2).text().toInt(),
                element.child(3).text()
            )
        } ?: emptyList<Person>()
    }

    suspend fun getLastPage(): Int = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
            .getElementsByAttributeValue("class", "pager-last")
            .last()?.child(0)?.attr("href")
            .toString().split("=")[1].toInt()
    }

    suspend fun getVaccinated(): String = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu").get()
            .getElementsByAttributeValue("id", "api-beoltottak").get(0).text()
    }

    suspend fun getMaxId(): String = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
            .getElementsByAttributeValue("class", "views-field views-field-field-elhunytak-sorszam")
            .get(1).text()
    }
}
