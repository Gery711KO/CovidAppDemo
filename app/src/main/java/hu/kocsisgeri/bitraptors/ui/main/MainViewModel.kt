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
    val vaccinated = repo.getCovidVaccinated().asLiveData()
    val maxId = repo.getCovidMaxId().asLiveData()

    val vaccinatedLoaded = MutableSharedFlow<String?>(0, 100)
    val maxIdLoaded = MutableSharedFlow<String?>(0, 100)
    val dataLoaded = vaccinatedLoaded.combine(maxIdLoaded) { vaccinated, maxid ->
        if (!vaccinated.isNullOrBlank() && !maxid.isNullOrBlank()) {
            ApiResult.Success(DataModel(vaccinated, maxid))
        } else {
            ApiResult.Error("Not loaded!")
        }
    }.asLiveData()

    val filtering = repo.filtering.asLiveData()
    val selected = MutableStateFlow<Int?>(null)

    fun refreshFunc() {
        repo.refreshData.tryEmit(Unit)
        repo.refreshCovid.tryEmit(Unit)
    }
}