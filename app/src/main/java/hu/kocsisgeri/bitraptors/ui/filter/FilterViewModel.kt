package hu.kocsisgeri.bitraptors.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import hu.kocsisgeri.bitraptors.data.logic.Filter
import hu.kocsisgeri.bitraptors.data.repository.CovidRepository

class FilterViewModel(private val repo: CovidRepository) : ViewModel() {

    private var previousFilter: Filter = Filter(null,null,null)
    val filter = repo.filter.asLiveData()

    fun filterButtonFunc(minAge: Int?, maxAge: Int?, keyWord: String?) {
        val newFilter = Filter(minAge, maxAge, keyWord)
        if (!isFilterEqual(previousFilter, newFilter)) {
            previousFilter = newFilter
            repo.filter.tryEmit(Filter(minAge, maxAge, keyWord))
            repo.filtering.tryEmit(Unit)
        }
    }

    private fun isFilterEqual(filter: Filter?, other: Filter?): Boolean {
        return (filter?.keyword == other?.keyword
                && filter?.minAge == other?.minAge
                && filter?.maxAge == other?.maxAge)
    }

    fun clearButtonFunc() {
        val resetFilter = Filter(null, null, null)
        if (!isFilterEqual(previousFilter, resetFilter)) {
            previousFilter = resetFilter
            repo.filter.tryEmit(resetFilter)
            repo.filtering.tryEmit(Unit)
        }
    }
}

