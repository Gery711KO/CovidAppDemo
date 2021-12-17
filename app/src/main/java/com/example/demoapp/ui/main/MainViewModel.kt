package com.example.demoapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.demoapp.database.AppDatabase
import com.example.demoapp.database.Person
import com.example.demoapp.database.PersonDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application){
    private val db:AppDatabase = AppDatabase.getInstance(application)
    var dao : PersonDao = db.personDao()

    lateinit var patients : LiveData<List<Person>>

    fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            patients = db.personDao().getData()
        }
    }

    fun insert(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            db.personDao().insertAll(person)
        }
    }
}