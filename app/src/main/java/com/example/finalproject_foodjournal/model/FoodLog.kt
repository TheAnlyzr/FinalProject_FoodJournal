package com.example.finalproject_foodjournal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodLog (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "log_id")
    val logID:Int,

    @ColumnInfo(name = "food_calories")
    val foodCalories: Int,
)