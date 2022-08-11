package com.myasser.architecture_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.myasser.architecture_practice.mvc.MVCMainActivity

class SelectActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        findViewById<AppCompatButton>(R.id.mvc_button).setOnClickListener(this)
        findViewById<AppCompatButton>(R.id.mvp_button).setOnClickListener(this)
        findViewById<AppCompatButton>(R.id.mvvm_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mvc_button ->startActivity(Intent(this@SelectActivity,MVCMainActivity::class.java))
            //todo: hook other buttons when views are declared
//            R.id.mvp_button ->startActivity(Intent(this@SelectActivity,MVCMainActivity::class.java))
//            R.id.mvvm_button ->startActivity(Intent(this@SelectActivity,MVCMainActivity::class.java))
        }
    }
}