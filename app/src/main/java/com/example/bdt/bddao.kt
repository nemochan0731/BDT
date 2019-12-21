package com.example.bdt

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface bddao {
    @Insert
     fun insertDB(db: DB)

    @Query("SELECT * FROM birthday")
     fun  getAllBD(): LiveData<List<DB>>

    @Query( "SELECT * FROM birthday WHERE id = ID")
     fun  getABD():DB

}