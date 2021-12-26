package hu.kocsisgeri.bitraptors

import hu.kocsisgeri.bitraptors.data.dao.Person
import hu.kocsisgeri.bitraptors.data.logic.Filter
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

class FilterUnitTest {
    val list = listOf<Person>(
        Person(1, "nő", 11, "cukor, daganat"),
        Person(2, "nő", 12, "magas vérnyomás, daganat"),
        Person(3, "nő", 22, "cukor"),
        Person(4, "nő", 13, "daganat"),
        Person(5, "nő", 18, "cukor, parkinson"),
        Person(6, "nő", 21, "cukor"),
        Person(7, "nő", 9, "cukor"),
        Person(8, "nő", 19, "daganat"),
        Person(9, "nő", 32, "daganat"),
    )

    @Test
    fun getFilteredListSizeIsCorrect() {
        val filter: Filter = Filter(10, 20, "cukor")
        val result = filter.getFilteredList(list)
        assertNotNull(result)
        assertEquals(2, result.size)
    }

    @Test
    fun getFilteredListReturnsCorrectItems() {
        val filter: Filter = Filter(10, 20, "cukor")
        val filtered = filter.getFilteredList(list)
        val expected = listOf<Person>(
            Person(1, "nő", 11, "cukor, daganat"),
            Person(5, "nő", 18, "cukor, parkinson"),
        )
        assertNotNull(filtered)
        assertEquals(expected, filtered)
    }

    @Test
    fun getFilteredListReturnsInCorrectItems_IntentionalTestFail() {
        val filter: Filter = Filter(10, 20, "cukor")
        val filtered = filter.getFilteredList(list)
        val expected = listOf<Person>(
            Person(1, "nő", 11, "cukor, daganat"),
            Person(5, "nő", 18, "cukor, parkinson"),
            Person(8, "nő", 19, "daganat" ),
        )
        assertNotNull(filtered)
        assertEquals(filtered, filtered)
    }
}