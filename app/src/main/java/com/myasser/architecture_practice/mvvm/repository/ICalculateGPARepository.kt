package com.myasser.architecture_practice.mvvm.repository

import androidx.lifecycle.MutableLiveData

interface ICalculateGPARepository {
    //create functions that will deal with view's inputs and will return the model object
    fun calculateGPA(name:String,grades:List<String>): MutableLiveData<Float>
}