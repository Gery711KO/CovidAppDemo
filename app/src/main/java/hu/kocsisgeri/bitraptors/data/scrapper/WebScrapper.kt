package hu.kocsisgeri.bitraptors.data.scrapper

import hu.kocsisgeri.bitraptors.data.dao.Person
import org.jsoup.Jsoup

class WebScrapper {
    suspend fun getDataFromWeb() : MutableList<Person>{
        val document = Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
        var patients = mutableListOf<Person>()
        val lastPage =
            document.getElementsByAttributeValue("class", "pager-last").last()?.child(0)
                ?.attr("href").toString().split("=")[1].toInt()

        //var index = 0
        //while (lastPage > index)
        //{
        //document = Jsoup.connect("https://koronavirus.gov.hu/elhunytak?page=$index").get()
        val tBodyChildren =document.select("tbody").firstOrNull()?.children()
        tBodyChildren?.forEach{
            val temp = Person(
                it.child(0).text().toInt(),
                it.child(1).text(),
                it.child(2).text().toInt(),
                it.child(3).text()
            )
            patients.add(temp)
        }
        //index++
        //}
        return patients
    }

    suspend fun getVaccinated() : Int? {
        return Jsoup.connect("https://koronavirus.gov.hu").get().getElementsByAttributeValue("id", "api-beoltottak").firstOrNull()?.text()?.toInt()
    }

    //A majd később megírásra kerülő update metódushoz segéd.
    suspend fun getMaxId() : Int? {
        return Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get().getElementsByAttributeValue("class", "views-field views-field-field-elhunytak-sorszam").firstOrNull()?.text()?.toInt()
    }
}