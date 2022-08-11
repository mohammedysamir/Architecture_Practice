package com.myasser.architecture_practice.mvp

interface IGPAPresenter {
    fun calculateGPA(name:String,grades:List<String>)
    //here we need to create functions that will do the calculations based on data passed from views
}