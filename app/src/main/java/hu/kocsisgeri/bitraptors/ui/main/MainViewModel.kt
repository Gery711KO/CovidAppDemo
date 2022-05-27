package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import hu.kocsisgeri.bitraptors.ui.model.PersonUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map

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

    val filtering = repo.filtering.asLiveData()

    val vaccinated = repo.getCovidVaccinated().asLiveData()

    val maxId = repo.getCovidMaxId().asLiveData()

    val selected = MutableStateFlow<Int?>(null)

    fun refreshFunc() {
        repo.refresh.tryEmit(Unit)
    }
}