package com.myasser.architecture_practice.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.myasser.architecture_practice.models.Student

class CalculateGPARepositoryImpl : ICalculateGPARepository {
    override fun calculateGPA(name: String, grades: List<String>): MutableLiveData<Float> {
        //create student object, assign params
        //we can do logic and return result
        val student = Student(name, grades)
        var gpa = 0.0f
        for (g in student.studentGrades) {
            when (g.uppercase()) {
                "A+" -> gpa += 4 * 3
                "A" -> gpa += 3.7f * 3
                "B+" -> gpa += 3.2f * 3
                "B" -> gpa += 3 * 3
                "C+" -> gpa += 2.7f * 3
                "C" -> gpa += 2.4f * 3
                "D+" -> gpa += 2.2f * 3
                "D" -> gpa += 2 * 3
            }
        }
        return MutableLiveData(gpa/(student.studentGrades.size * 3))
    }
}