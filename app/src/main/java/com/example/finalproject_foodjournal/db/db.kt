package com.example.finalproject_foodjournal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalproject_foodjournal.dao.DaoFoodLog
import com.example.finalproject_foodjournal.dao.DaoUser
import com.example.finalproject_foodjournal.model.FoodLog
import com.example.finalproject_foodjournal.model.User

@Database(entities = [User::class, FoodLog::class], version = 1)
abstract class db: RoomDatabase()  {
    abstract val userDao: DaoUser
    abstract val foodLogDao: DaoFoodLog

    companion object{
        @Volatile
        private var INSTANCE: db? = null
        fun getInstance(context: Context): db {
            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        db::class.java,
                        "food_journal_db"
                    ).build()
                }
                return instance
            }
        }
    }
}