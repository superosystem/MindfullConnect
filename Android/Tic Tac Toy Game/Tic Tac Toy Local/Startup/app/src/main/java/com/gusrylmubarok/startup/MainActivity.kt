package com.gusrylmubarok.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button

        var cellId = 0
        when(buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }

        playGame(cellId, buSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buSelected: Button) {
        if(activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(R.color.whitedarkGreen)
            player2.add(cellId)
            autoPlay()
        }
        buSelected.isEnabled = false

        checkWinner()
    }
}