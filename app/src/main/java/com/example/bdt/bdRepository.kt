package com.example.bdt

import android.app.Application
import androidx.lifecycle.LiveData

abstract class bdRepository {
    abstract val bddao_val:bddao
    abstract val alldb : LiveData<List<DB>>
    public fun bdRepository(application: Application){
        val database:bdDatabase
    }
}