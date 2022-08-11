package com.myasser.architecture_practice.mvp

import com.myasser.architecture_practice.models.Student

class GPAPresenter(val view:IView):IGPAPresenter {
    //implement IGPAPresenter functions
    override fun calculateGPA(name:String,grades: List<String>) {
//        var gpa = 0f
//        for (g in grades) {
//            //here I considered all subjects to be 3 hours
//            when (g.uppercase()) {
//                "A+" -> gpa += 4 * 3
//                "A" -> gpa += 3.7f * 3
//                "B+" -> gpa += 3.2f * 3
//                "B" -> gpa += 3 * 3
//                "C+" -> gpa += 2.7f * 3
//                "C" -> gpa += 2.4f * 3
//                "D+" -> gpa += 2.2f * 3
//                "D" -> gpa += 2 * 3
//            }
//        }
//        return gpa / (grades.size * 3)

        //define model object and set data to it
        val student=Student(name,grades)
        view.setUserGPA(student)
    }
    //Create interface for views
    interface IView{
        fun setUserGPA(student: Student)
    }
}