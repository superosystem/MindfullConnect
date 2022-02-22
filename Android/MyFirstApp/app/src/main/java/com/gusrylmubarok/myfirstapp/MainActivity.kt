package com.gusrylmubarok.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialization Component
        var thnLahir = findViewById<EditText>(R.id.thnLahir)
        var btnThnLahir = findViewById<Button>(R.id.btnThnLahir)
        var viewCat = findViewById<TextView>(R.id.viewCat)

        btnThnLahir.setOnClickListener {
            val input = thnLahir.text.toString()
            val hasil = when (input.toInt()) {
                in 1946..1964 -> "Baby Boomers"
                in 1965..1980 -> "X"
                in 1981..1995 -> "Millenial"
                in 1996..2010 -> "Z"
                else -> "Not Human"
            }

            viewCat.text = "Kamu Generasi $hasil"
        }
    }
}