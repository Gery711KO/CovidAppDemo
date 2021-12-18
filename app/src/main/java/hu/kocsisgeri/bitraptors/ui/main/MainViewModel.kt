package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(repo : CovidRepository) : ViewModel() {
    val covids = repo.getCovidList().asLiveData()
}