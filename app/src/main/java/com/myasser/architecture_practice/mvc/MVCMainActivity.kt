package com.myasser.architecture_practice.mvc

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.myasser.architecture_practice.R
import com.myasser.architecture_practice.models.Student

class MVCMainActivity : AppCompatActivity() {
    private lateinit var studentNameEditText: EditText
    private lateinit var studentGradeEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvcmain)
        studentNameEditText = findViewById(R.id.mvc_student_name_edit)
        studentGradeEditText = findViewById(R.id.mvc_student_grades_edit)
        findViewById<AppCompatButton>(R.id.mvc_calculate_button).setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            //here we will define object of our model -> update
            val student = Student(studentName, studentGradeEditText.text.toString().split(","))
            //we will update the View with data notified by student
            findViewById<TextView>(R.id.mvc_result).text =
                "${studentName}, You got ${calculateGPA(student)}"
        }
    }

    private fun calculateGPA(student: Student): Float {
        //build switch case to match grades list
        var gpa = 0f
        for (g in student.studentGrades) {
            //here I considered all subjects to be 3 hours
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
        return gpa / (student.studentGrades.size * 3) //gpa ( #hours * hours_val)
    }
}
/*
* MVC contains:
*   1. Model -> Data storage {data class, database, API } =>in this example we will declare Student(name,grades_list)
*   2. View -> UI elements => in this example the view will be activity_mvcmain
*   3. Controller -> Control view and updates both Model and View =>  in this example the controller will be MVCMainActivity
* MVC drawback:
*   1. Controller and View is interdependent because of android templates (creates controller and view together 'activity')
*   2. Can't fit in high scale applications.
* */