package com.gusrylmubarok.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun BuClickEvent(view: View) {
        val etDOB = findViewById<EditText>(R.id.etDOB)
        val tvShowAge = findViewById<TextView>(R.id.tvShowAge)

        val userDOB:String = etDOB.text.toString()
        if(userDOB.toInt() == 0) {
            tvShowAge.text = " invalid input"
            return
        }

        val year:Int = Calendar.getInstance().get(Calendar.YEAR)
        val myAge   = year - userDOB.toInt()
        val avg     = myAge / userDOB.toInt()
        tvShowAge.text = "Yout age is $myAge"
    }
}