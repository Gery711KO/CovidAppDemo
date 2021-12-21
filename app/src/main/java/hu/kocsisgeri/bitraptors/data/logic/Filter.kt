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
    fun getFilteredList(list: List<Person>) : List<Person> {
        list.filter{ x ->
            x.age > minAge?: 0 &&
            x.age < maxAge?: 150 &&
            x.baseIllnesses.lowercase().contains(keyword?.lowercase()?: "") &&
            x.sex.lowercase().contains(keyword?.lowercase()?: "")
        }
        return list
    }
}