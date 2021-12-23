package hu.kocsisgeri.bitraptors.data.logic

import androidx.compose.ui.text.toLowerCase
import hu.kocsisgeri.bitraptors.data.dao.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class Filter(
    val minAge: Int? = null,
    val maxAge: Int? = null,
    val keyword: String? = null
) {
    fun getFilteredList(list: List<Person>): List<Person> {

        return list.filter {
            it.age >= this.minAge ?: 0 &&
                    it.age <= this.maxAge ?: 150 &&
                    (it.baseIllnesses.lowercase().contains(this.keyword?.lowercase() ?: "") ||
                            it.sex.lowercase().contains(this.keyword?.lowercase() ?: ""))
        }
    }
}