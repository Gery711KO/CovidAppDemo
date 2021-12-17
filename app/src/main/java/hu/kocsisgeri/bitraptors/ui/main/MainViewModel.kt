package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(repo : CovidRepository) : ViewModel() {
    val covids = liveData<List<Any>>(Dispatchers.IO) {
        emit(emptyList())
    }
}