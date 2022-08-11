package com.myasser.architecture_practice.mvp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.myasser.architecture_practice.R
import com.myasser.architecture_practice.models.Student

class MVPMainActivity : AppCompatActivity(), GPAPresenter.IView {
    lateinit var studentNameEdit: EditText
    lateinit var studentGradesEdit: EditText

    //create object of presenter
    lateinit var gpaPresenter: GPAPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvpmain)
        studentNameEdit = findViewById(R.id.mvp_student_name_edit)
        studentGradesEdit = findViewById(R.id.mvp_student_grades_edit)
        gpaPresenter = GPAPresenter(this)

        findViewById<AppCompatButton>(R.id.mvp_calculate_button).setOnClickListener {
            val studentName = studentNameEdit.text.toString().trim()
            val studentGrades = studentGradesEdit.text.toString().split(",")
            gpaPresenter.calculateGPA(studentName, studentGrades)//fire presenter event
        }

    }

    //update ui elements by data fetched by the student
    override fun setUserGPA(student: Student) {
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
        findViewById<TextView>(R.id.mvp_result).text =
            "${student.studentName},You got ${gpa / (student.studentGrades.size * 3)}"
    }
}
/*
* MVP:
*   1. In MVP we have the view separated from the Presenter(Controller).
*   2. View -> MVPMainActivity & activity_mvpmain.xml
*   3. Model -> Student.
*   4. Presenter ->
*       4.1. We need to create Interface for each presenter. -> add functionalities that will do calculations (functionalities)
*       4.2. We need to create concrete class for each interface. -> add parameter for the linked view
*       4.3. Create inline interface in the concrete presenter class to connect view with the presenter (callback) -> this functions will be implemented in the view itself to update its layouts
* */