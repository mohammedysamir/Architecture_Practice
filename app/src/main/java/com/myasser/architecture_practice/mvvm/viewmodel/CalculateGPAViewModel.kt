package com.myasser.architecture_practice.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.myasser.architecture_practice.mvvm.repository.CalculateGPARepositoryImpl

//extend ViewModel class
class CalculateGPAViewModel:ViewModel() {
    //create repository object to call its function, preferred to create same function signature as repository
    //will return LiveData<> -> no need to modify it in view
    val repoObj=CalculateGPARepositoryImpl()
    fun calculateGPA(name: String, grades: List<String>): LiveData<Float>{
        return repoObj.calculateGPA(name,grades)
    }
}