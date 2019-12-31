package com.example.bdt

import android.app.Application
import androidx.lifecycle.LiveData

class bdRepository( private val bdDao: bddao) {

    val alldb : LiveData<List<DB>> = bdDao.getAllBD()

    suspend fun  insertBD(bd:DB){
        bdDao.insertDB(bd)
    }


}