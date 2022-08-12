package com.myasser.architecture_practice.mvp

import com.myasser.architecture_practice.models.Student

class GPAPresenter(val view:IView):IGPAPresenter {
    //implement IGPAPresenter functions
    override fun calculateGPA(name:String,grades: List<String>) {
        //define model object and set data to it
        val student=Student(name,grades)
        view.setUserGPA(student)
    }
    //Create interface for views
    interface IView{
        fun setUserGPA(student: Student)
    }
}