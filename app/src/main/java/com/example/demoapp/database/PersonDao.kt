package com.example.demoapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao {
    @Query("SELECT * FROM person WHERE person_age=(:age)")
    suspend fun findByAge(age: Int): List<Person>

    @Query("SELECT * FROM person WHERE person_age>=(:age)")
    suspend fun findByAgeGreaterEquals(age: Int): List<Person>

    @Query("SELECT * FROM person WHERE person_age<=(:age)")
    suspend fun findByAgeLessEquals(age: Int): List<Person>

    @Query("SELECT * FROM person")
    suspend fun getData(): LiveData<List<Person>>

    @Insert
    suspend fun insertAll(vararg users: Person)
}