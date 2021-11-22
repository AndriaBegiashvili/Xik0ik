package com.example.krestiknolik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var pl1 = 0
    var pl2 = 0
    private lateinit var txt1 : TextView
    private lateinit var txt2 : TextView
    private lateinit var a1 : Button
    private lateinit var a2 : Button
    private lateinit var a3 : Button
    private lateinit var a4 : Button
    private lateinit var a5 : Button
    private lateinit var a6 : Button
    private lateinit var a7 : Button
    private lateinit var a8 : Button
    private lateinit var a9 : Button
    private lateinit var refresh :Button
    private lateinit var newG : Button
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var butNum = 0
            when(clickedView.id){
                R.id.a1 -> butNum = 1
                R.id.a2 -> butNum = 2
                R.id.a3 -> butNum = 3
                R.id.a4 -> butNum = 4
                R.id.a5 -> butNum = 5
                R.id.a6 -> butNum = 6
                R.id.a7 -> butNum = 7
                R.id.a8 -> butNum = 8
                R.id.a9 -> butNum = 9
                R.id.refresh -> reload()
                R.id.newG -> axlidan()

            }
            if(butNum != 0){
                playGame(clickedView,butNum)
            }

        }
    }

    private fun playGame(clickedView: Button, butNum: Int) {
        if(activePlayer == 1){
            clickedView.text = "X"
            clickedView.setTextColor(Color.BLUE)
            activePlayer = 2
            firstPlayer.add(butNum)
        }
        else{
            clickedView.text = "O"
            activePlayer = 1
            clickedView.setTextColor(Color.RED)
            secondPlayer.add(butNum)
        }
        clickedView.isEnabled = false
        check()

    }

    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (winnerPlayer != 1 && winnerPlayer != 2 && firstPlayer.count()>4 && secondPlayer.count() == 4){
            Toast.makeText(this, "ITS DRAW", Toast.LENGTH_SHORT).show()
        }
        else if (winnerPlayer == 1){
            pl1++
            txt1.text = "player 1 : $pl1"
            disableBox()
            Toast.makeText(this, "Player 1 Won", Toast.LENGTH_SHORT).show()
        }
        else if (winnerPlayer == 2){
            pl2++
            txt2.text = "player 2 : $pl2"
            disableBox()
            Toast.makeText(this, "Player 2 Won", Toast.LENGTH_SHORT).show()
        }



    }

    private fun init(){
        a1 = findViewById(R.id.a1)
        a2 = findViewById(R.id.a2)
        a3 = findViewById(R.id.a3)
        a4 = findViewById(R.id.a4)
        a5 = findViewById(R.id.a5)
        a6 = findViewById(R.id.a6)
        a7 = findViewById(R.id.a7)
        a8 = findViewById(R.id.a8)
        a9 = findViewById(R.id.a9)
        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)
        refresh = findViewById(R.id.refresh)
        newG = findViewById(R.id.newG)



        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        a4.setOnClickListener(this)
        a5.setOnClickListener(this)
        a6.setOnClickListener(this)
        a7.setOnClickListener(this)
        a8.setOnClickListener(this)
        a9.setOnClickListener(this)
        refresh.setOnClickListener(this)
        newG.setOnClickListener(this)

    }


    private fun disableBox () {
        a1.isEnabled = false
        a2.isEnabled = false
        a3.isEnabled = false
        a4.isEnabled = false
        a5.isEnabled = false
        a6.isEnabled = false
        a7.isEnabled = false
        a8.isEnabled = false
        a9.isEnabled = false
    }

    fun reload (){
        init()
        a1.isEnabled = true
        a2.isEnabled = true
        a3.isEnabled = true
        a4.isEnabled = true
        a5.isEnabled = true
        a6.isEnabled = true
        a7.isEnabled = true
        a8.isEnabled = true
        a9.isEnabled = true
        a1.text = ""
        a2.text = ""
        a3.text = ""
        a4.text = ""
        a5.text = ""
        a6.text = ""
        a7.text = ""
        a8.text = ""
        a9.text = ""
        activePlayer = 1
        firstPlayer = ArrayList<Int>()
        secondPlayer = ArrayList<Int>()
    }
    fun axlidan (){
        init()
        txt1.text = "player 1 : 0"
        pl1=0
        txt2.text = "player 2 : 0"
        pl2=0
        reload()

    }


    }




