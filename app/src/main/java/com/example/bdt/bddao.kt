package com.example.bdt

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface bddao {
   @Insert
    suspend fun insertDB(db: DB)
   // @Query ("insert into birthday('name','dob') values( :db ,:db)")
    //suspend fun insertDB(db: DB)

    @Update
    suspend fun updateBD(bd:DB)

    @Delete
    suspend fun deleteBD(db:DB)

    @Query("SELECT * FROM birthday")
     fun  getAllBD(): LiveData<List<DB>>

    @Query( "SELECT * FROM birthday WHERE id = :ID")
     fun  getABD(ID:Int):DB

}