package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.*
import hu.kocsisgeri.bitraptors.data.repository.ApiResult
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository
import hu.kocsisgeri.bitraptors.ui.model.PersonUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map

class MainViewModel(repo : CovidRepository) : ViewModel() {

    val covids = repo.getCovidList().flatMapLatest{ personList ->
        selected.map { selected ->
            if (personList is ApiResult.Success) {
                val asd = personList.data.map{
                    if (it.id == selected){
                        PersonUI(it, true)
                    } else PersonUI(it, false)
                }
                ApiResult.Success(asd)
            } else if (personList is ApiResult.Progress) {
                ApiResult.Progress(personList.percentage)
            } else {
                ApiResult.Error("Error")
            }
        }
    }.asLiveData()

    val vaccinated = repo.getCovidVaccinated().asLiveData()

    val maxId = repo.getCovidMaxId().asLiveData()

    val selected = MutableStateFlow<Int?>(null)
}