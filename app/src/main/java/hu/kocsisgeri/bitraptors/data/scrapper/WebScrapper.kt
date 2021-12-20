package hu.kocsisgeri.bitraptors.data.scrapper

import hu.kocsisgeri.bitraptors.data.dao.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class WebScrapper {
    var list = mutableListOf<Person>()

    suspend fun getDataFromWeb(index: Int) : List<Person> = withContext(Dispatchers.IO) {
        val doc = Jsoup.connect("https://koronavirus.gov.hu/elhunytak?page=$index").get()
        val children = doc.select("tbody").firstOrNull()?.children()

        children?.map { element ->
             Person(
                id = element.child(0).text().toInt(),
                sex = element.child(1).text(),
                age = element.child(2).text().toInt(),
                baseIllnesses = element.child(3).text())
        }?: emptyList<Person>()
    }

    suspend fun getLastPage() : Int = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
            .getElementsByAttributeValue("class", "pager-last")
            .last()?.child(0)?.attr("href")
            .toString().split("=")[1].toInt()
    }

    suspend fun getVaccinated() : String? = withContext(Dispatchers.IO) {
        Jsoup.connect("https://koronavirus.gov.hu").get()
            .getElementsByAttributeValue("id", "api-beoltottak").firstOrNull()?.text()
    }

        suspend fun getMaxId() : String? = withContext(Dispatchers.IO) {
            Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
                .getElementsByAttributeValue("class", "views-field views-field-field-elhunytak-sorszam")
                .get(1).text()
        }

    /*if (children != null) {
        for (element in children) {
            val temp = Person(
                element.child(0).text().toInt(),
                element.child(1).text(),
                element.child(2).text().toInt(),
                element.child(3).text()
            )
            list.add(temp)
        }
    }
    list*/
}
