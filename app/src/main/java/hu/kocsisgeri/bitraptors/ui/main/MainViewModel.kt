package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import hu.kocsisgeri.bitraptors.data.scrapper.InternetChecker
import kotlinx.coroutines.flow.map

class MainViewModel(repo : CovidRepository) : ViewModel() {
    val covids = repo.getCovidList().asLiveData()

    //al covidsSize = covids.value.s

    val dbSize = repo.getDatabaseSize().asLiveData()

    val vaccinated = repo.getCovidVaccinated().asLiveData()

    val maxId = repo.getCovidMaxId().asLiveData()
}