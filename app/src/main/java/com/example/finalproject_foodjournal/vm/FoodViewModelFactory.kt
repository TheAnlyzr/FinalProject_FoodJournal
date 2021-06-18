package com.example.finalproject_foodjournal.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject_foodjournal.db.RepoFoodLog

class FoodViewModelFactory(private val repo: RepoFoodLog): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repo) as T
        }
        if(modelClass.isAssignableFrom(ReportViewModel::class.java)){
            return ReportViewModel(repo) as T
        }

        throw  IllegalArgumentException("Unknown View Model Class")
    }

}
