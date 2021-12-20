package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import hu.kocsisgeri.bitraptors.data.scrapper.InternetChecker
import kotlinx.coroutines.flow.map

class MainViewModel(repo : CovidRepository) : ViewModel() {
    val covids = repo.getCovidList().map{
        it.subList(it.size-50,it.size).sortedByDescending { x -> x.id }
    }.asLiveData()

    val covidsSize = covids.map{
        it.size
    }

    val dbSize = repo.getDatabaseSize().asLiveData()

    val vaccinated = repo.getCovidVaccinated().asLiveData()

    val maxId = repo.getCovidMaxId().asLiveData()
}