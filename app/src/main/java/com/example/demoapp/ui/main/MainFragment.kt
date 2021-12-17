package com.example.demoapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.demoapp.R
import com.example.demoapp.database.AppDatabase
import com.example.demoapp.database.Person
import com.example.demoapp.database.PersonDao
import com.example.demoapp.logic.WebScraper
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private lateinit var model: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel


    }

}