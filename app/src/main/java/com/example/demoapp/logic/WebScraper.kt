package com.example.demoapp.logic

import com.example.demoapp.database.Person
import com.example.demoapp.database.PersonDao
import org.jsoup.Jsoup
import kotlin.properties.Delegates

class WebScraper(dao : PersonDao) {
    var patients = mutableListOf<Person>()
    var lastPage: Int by Delegates.notNull<Int>()
    //val peopleDao : PersonDao

    suspend fun getDataFromWeb() : MutableList<Person>{
        var document = Jsoup.connect("https://koronavirus.gov.hu/elhunytak").get()
        lastPage =
            document.getElementsByAttributeValue("class", "pager-last").last().child(0)
                .attr("href").toString().split("=")[1].toInt()

        //var index = 0
        //while (lastPage > index)
        //{
            //document = Jsoup.connect("https://koronavirus.gov.hu/elhunytak?page=$index").get()
            for (element in document.select("tbody").first().children()) {
                val temp = Person(
                    element.child(0).text().toInt(),
                    element.child(1).text(),
                    element.child(2).text().toInt(),
                    element.child(3).text()
                )
            patients.add(temp)
            }
            //index++
        //}
        return patients
    }
}