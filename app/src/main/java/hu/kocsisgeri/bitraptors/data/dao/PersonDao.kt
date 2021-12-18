package hu.kocsisgeri.bitraptors.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Dao
interface PersonDao {
    @Query("SELECT * FROM person WHERE person_age=(:age)")
    suspend fun findByAge(age: Int): List<Person>

    @Query("SELECT * FROM person WHERE person_age>=(:age)")
    suspend fun findByAgeGreaterEquals(age: Int): List<Person>

    @Query("SELECT * FROM person WHERE person_age<=(:age)")
    suspend fun findByAgeLessEquals(age: Int): List<Person>

    @Query("SELECT * FROM person")
    fun getLiveData(): LiveData<List<Person>>

    @Query("SELECT * FROM person")
    suspend fun getData(): List<Person>

    @Insert
    suspend fun insertAll(list: List<Person>)
}