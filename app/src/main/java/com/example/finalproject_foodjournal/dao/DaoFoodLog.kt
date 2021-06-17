package com.example.finalproject_foodjournal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.finalproject_foodjournal.model.FoodLog

@Dao
interface DaoFoodLog {
    @Insert
    suspend fun insertFoodLog(log: FoodLog)

    @Update
    suspend fun updateFoodLog(log: FoodLog)

    @Delete
    suspend fun deleteFoodLog(log: FoodLog)

    @Query("SELECT * FROM foodlog")
    fun loadAllLog(): LiveData<List<FoodLog>>

    @Query("SELECT * FROM user WHERE user_id LIKE :logID")
    fun loadLog(logID: Int): LiveData<List<FoodLog>>
}