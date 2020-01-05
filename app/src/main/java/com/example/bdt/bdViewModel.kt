package com.example.bdt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class bdViewModel(application: Application):AndroidViewModel(application){

    private val bdrepository: bdRepository
    val allbd : LiveData<List<DB>>

    init {
        val bdDao= bdDatabase.getInstance(application).bdDao()
        bdrepository = bdRepository(bdDao)
        allbd = bdrepository.alldb
    }


    fun insertBD( bd:DB) = viewModelScope.launch {
        bdrepository.insertBD(bd)
    }

}