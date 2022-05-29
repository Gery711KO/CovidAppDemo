package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import androidx.lifecycle.asLiveData
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import hu.kocsisgeri.bitraptors.ui.model.DataModel
import hu.kocsisgeri.bitraptors.ui.model.PersonUI
import kotlinx.coroutines.flow.*

class MainViewModel(private val repo: CovidRepository) : ViewModel() {

    val covids = repo.getCovidList().flatMapLatest { personList ->
        selected.map { selected ->
            when (personList) {
                is ApiResult.Error -> ApiResult.Error(personList.error)
                is ApiResult.Progress -> ApiResult.Progress(personList.percentage)
                is ApiResult.Success -> ApiResult.Success(personList.data.map {
                    PersonUI(person = it, isOpened = it.id == selected)
                })
            }
        }
    }.asLiveData()

    val dataLoaded = repo.getCovidVaccinated().combine(repo.getCovidMaxId()) { vaccinated, maxId ->
        when {
            vaccinated is ApiResult.Success && maxId is ApiResult.Success -> {
                if (vaccinated.data.isNotBlank() && maxId.data.isNotBlank()) {
                    ApiResult.Success(DataModel(vaccinated.data, maxId.data))
                } else {
                    ApiResult.Error("Not loaded!")
                }
            }
            else -> {
                ApiResult.Error("Unknown error!")
            }
        }
    }.asLiveData()

    val filtering = repo.filtering.asLiveData()
    val selected = MutableStateFlow<Int?>(null)

    fun refreshFunc() {
        repo.refreshData.tryEmit(Unit)
        repo.refreshCovid.tryEmit(Unit)
    }
}