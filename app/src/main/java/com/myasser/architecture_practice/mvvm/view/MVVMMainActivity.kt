package com.myasser.architecture_practice.mvvm.view

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import com.myasser.architecture_practice.R
import com.myasser.architecture_practice.mvvm.viewmodel.CalculateGPAViewModel

class MVVMMainActivity : AppCompatActivity() {
    lateinit var studentNameEdit: EditText
    lateinit var studentGradeEdit: EditText
    lateinit var viewModel: CalculateGPAViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmmain)
        studentNameEdit = findViewById(R.id.mvvm_student_name_edit)
        studentGradeEdit = findViewById(R.id.mvvm_student_grades_edit)
        viewModel = CalculateGPAViewModel()
        findViewById<AppCompatButton>(R.id.mvvm_calculate_button).setOnClickListener {
            //send data to view model and observe results.
            val studentName = studentNameEdit.text.toString().trim()
            val studentGradesList = studentGradeEdit.text.toString().split(",")
            viewModel.calculateGPA(studentName, studentGradesList).observe(this, Observer { gpa ->
                //this will be fired whenever the ViewModel returns LiveData
                findViewById<TextView>(R.id.mvvm_result).text = "${studentName}, You got ${gpa}"
            })
        }
    }
}
/*
* MVVM:
*   1. consists of Model, ViewModel, View, and Repository.
*   2. View sends data to ViewModel and observe results.
*   3. ViewModel can't communicate directly with Models. => more layer's added
*   4. Repository deals with Data models (local or remote).
*   5. VM calls repository's function to update and fetch data using MutableLiveData<T>
    6. View observes changes in VM using .observe() function

    Repository: we need to declare an interface and concrete class for each VM, those functions will have parameters with view's inputs
    * Repository will send those data to model and update it, fetch new data and return MutableLiveData<T> to the ViewModel
    * ViewModel need to have same parameters and a repo object to fire repo's function and get LiveData<T>
    * When VM receives new data, the observer block in View will be executed and set new data into UI.
* */