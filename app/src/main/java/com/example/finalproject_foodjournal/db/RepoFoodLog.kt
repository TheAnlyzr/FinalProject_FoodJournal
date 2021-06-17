package com.example.finalproject_foodjournal.db

import com.example.finalproject_foodjournal.dao.DaoFoodLog
import com.example.finalproject_foodjournal.model.FoodLog

class RepoFoodLog(private val dao: DaoFoodLog) {
    suspend fun insert(log: FoodLog){
        dao.insertFoodLog(log)
    }

    suspend fun update(log: FoodLog){
        dao.updateFoodLog(log)
    }

    suspend fun delete(log: FoodLog){
        dao.deleteFoodLog(log)
    }
}