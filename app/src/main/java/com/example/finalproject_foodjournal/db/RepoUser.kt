package com.example.finalproject_foodjournal.db

import com.example.finalproject_foodjournal.dao.DaoUser
import com.example.finalproject_foodjournal.model.User

class RepoUser(private val dao: DaoUser) {
    suspend fun insert(user: User){
        dao.insertUser(user)
    }

    suspend fun update(user: User){
        dao.updateUser(user)
    }

    suspend fun delete(user: User){
        dao.deleteUser(user)
    }
}