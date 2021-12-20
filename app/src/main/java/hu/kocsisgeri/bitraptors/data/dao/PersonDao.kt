package hu.kocsisgeri.bitraptors.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    suspend fun getData(): List<Person>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(list: List<Person>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOne(person: Person)
}