package hu.kocsisgeri.bitraptors.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import hu.kocsisgeri.bitraptors.data.logic.Filter
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository

class FilterViewModel (private val repo : CovidRepository) : ViewModel() {
    val filter = repo.filter.asLiveData()

    fun filterButtonFunc(minAge: Int, maxAge: Int, keyWord: String){
        repo.filter.tryEmit(Filter(minAge,maxAge,keyWord))
    }

    fun clearButtonFunc(){
        repo.filter.tryEmit(Filter(null, null, null))
    }
}