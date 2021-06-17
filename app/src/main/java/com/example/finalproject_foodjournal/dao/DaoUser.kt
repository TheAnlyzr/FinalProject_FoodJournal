package com.example.finalproject_foodjournal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.finalproject_foodjournal.model.User

@Dao
interface DaoUser {
    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    fun loadAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE user_id LIKE :userID")
    fun loadUser(userID: Int): LiveData<List<User>>
}