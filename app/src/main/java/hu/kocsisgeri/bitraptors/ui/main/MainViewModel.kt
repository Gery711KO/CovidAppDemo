package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository

class MainViewModel(repo : CovidRepository) : ViewModel() {
    val covids = repo.getCovidList().asLiveData()

    val vaccinated = repo.getCovidVaccinated().asLiveData()

    val maxId = repo.getCovidMaxId().asLiveData()
}