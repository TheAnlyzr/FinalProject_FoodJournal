package com.example.finalproject_foodjournal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userID:Int,
    val name: String,
    val age: Int,
    val height: Double,
    val weight: Double,
)
