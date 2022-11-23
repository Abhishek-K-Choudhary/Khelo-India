package com.uttamsaha.kheloindia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var btnZero : Button
    lateinit var btnOne : Button
    lateinit var btnTwo : Button
    lateinit var btnThree : Button
    lateinit var btnFour : Button
    lateinit var btnFive : Button
    lateinit var btnSix : Button
    lateinit var btnAdd : Button
    lateinit var txtRun : TextView
    lateinit var txtOver : TextView
    lateinit var txtRunRate : TextView
    lateinit var txtBatsman1 : TextView
    lateinit var txtBatsman1Run : TextView
    lateinit var txtBatsman1Ball : TextView
    lateinit var txtBatsman1Four : TextView
    lateinit var txtBatsman1Six : TextView
    lateinit var txtBatsman1SR : TextView
    lateinit var txtBatsman2 : TextView
    lateinit var txtBatsman2Run : TextView
    lateinit var txtBatsman2Ball : TextView
    lateinit var txtBatsman2Four : TextView
    lateinit var txtBatsman2Six : TextView
    lateinit var txtBatsman2SR : TextView
    lateinit var btnSwap : Button
    lateinit var cbWide : CheckBox
    lateinit var cbNoBall : CheckBox
    lateinit var cbBye : CheckBox
    lateinit var cbLegBye : CheckBox
    lateinit var cbWicket : CheckBox
    lateinit var txtThisOver1 : TextView
    lateinit var txtThisOver2 : TextView
    lateinit var txtThisOver3 : TextView
    lateinit var txtThisOver4 : TextView
    lateinit var txtThisOver5 : TextView
    lateinit var txtThisOver6 : TextView
    lateinit var txtThisOver7 : TextView
    lateinit var txtThisOver8 : TextView
    lateinit var txtThisOver9 : TextView
    lateinit var txtThisOver10 : TextView

    var score : Int = 0
    var ballCount : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnZero = findViewById(R.id.btnZero)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnAdd = findViewById(R.id.btnAdd)
        btnSwap = findViewById(R.id.btnSwap)

        txtRun = findViewById(R.id.txtRun)
        txtOver = findViewById(R.id.txtOver)
        txtRunRate = findViewById(R.id.txtRunRate)

        txtBatsman1 = findViewById(R.id.txtBatsman1)
        txtBatsman1Run = findViewById(R.id.txtBatsman1Run)
        txtBatsman1Ball = findViewById(R.id.txtBatsman1Ball)
        txtBatsman1Four = findViewById(R.id.txtBatsman1Four)
        txtBatsman1Six = findViewById(R.id.txtBatsman1Six)
        txtBatsman1SR = findViewById(R.id.txtBatsman1SR)

        txtBatsman2 = findViewById(R.id.txtBatsman2)
        txtBatsman2Run = findViewById(R.id.txtBatsman2Run)
        txtBatsman2Ball = findViewById(R.id.txtBatsman2Ball)
        txtBatsman2Four = findViewById(R.id.txtBatsman2Four)
        txtBatsman2Six = findViewById(R.id.txtBatsman2Six)
        txtBatsman2SR = findViewById(R.id.txtBatsman2SR)

        cbWide = findViewById(R.id.cbWide)
        cbNoBall = findViewById(R.id.cbNoBall)
        cbBye = findViewById(R.id.cbBye)
        cbLegBye = findViewById(R.id.cbLegBye)
        cbWicket = findViewById(R.id.cbWicket)

        txtThisOver1 = findViewById(R.id.txtThisOver1)
        txtThisOver2 = findViewById(R.id.txtThisOver2)
        txtThisOver3 = findViewById(R.id.txtThisOver3)
        txtThisOver4 = findViewById(R.id.txtThisOver4)
        txtThisOver5 = findViewById(R.id.txtThisOver5)
        txtThisOver6 = findViewById(R.id.txtThisOver6)
        txtThisOver7 = findViewById(R.id.txtThisOver7)
        txtThisOver8 = findViewById(R.id.txtThisOver8)
        txtThisOver9 = findViewById(R.id.txtThisOver9)
        txtThisOver10 = findViewById(R.id.txtThisOver10)

        var currBatsman : Int = 1
        btnSwap.setOnClickListener{
            if (currBatsman==1)
                currBatsman=2
            else
                currBatsman=1
        }
        btnZero.setOnClickListener{
            countScore(0)
            if(!cbWide.isChecked || !cbBye.isChecked || !cbLegBye.isChecked || !cbWicket.isChecked || cbNoBall.isChecked){
                batsmanScore(0,currBatsman)
            }
        }
        btnOne.setOnClickListener{
            countScore(1)
            batsmanScore(1,currBatsman)
        }
        btnTwo.setOnClickListener{
            countScore(2)
            batsmanScore(2,currBatsman)
        }
        btnThree.setOnClickListener{
            countScore(3)
            batsmanScore(3,currBatsman)
        }
        btnFour.setOnClickListener{
            countScore(4)
            batsmanScore(4,currBatsman)
        }
        btnFive.setOnClickListener{
            countScore(5)
            batsmanScore(5,currBatsman)
        }
        btnSix.setOnClickListener{
            countScore(6)
            batsmanScore(6,currBatsman)
        }
    }

    private fun countScore(run : Int) {
        ballCount++
        score += run
        txtRun.text = score.toString()
        val overCount : Double = (ballCount/6)+((ballCount%6)*0.1)
        txtOver.text = overCount.toString()
        val rr  = ((6*score.toDouble()/ballCount.toDouble())*100.0).roundToInt()/100.0
        txtRunRate.text = rr.toString()

        if(ballCount%6==1) {
            txtThisOver1.text = run.toString()
            txtThisOver2.text = ""
            txtThisOver3.text = ""
            txtThisOver4.text = ""
            txtThisOver5.text = ""
            txtThisOver6.text = ""
        }
        else if(ballCount%6==2)
            txtThisOver2.text = run.toString()
        else if(ballCount%6==3)
            txtThisOver3.text = run.toString()
        else if(ballCount%6==4)
            txtThisOver4.text = run.toString()
        else if(ballCount%6==5)
            txtThisOver5.text = run.toString()
        else if(ballCount%6==0)
            txtThisOver6.text = run.toString()
    }

    private fun batsmanScore(run : Int,batsmanNo : Int){
        if(batsmanNo==1){
            var batsmanRun = txtBatsman1Run.text.toString().toInt()
            batsmanRun += run
            txtBatsman1Run.text = batsmanRun.toString()

            var batsmanBall = txtBatsman1Ball.text.toString().toInt()
            batsmanBall++
            txtBatsman1Ball.text = batsmanBall.toString()

            if(run==4) {
                var batsmanFour = txtBatsman1Four.text.toString().toInt()
                batsmanFour++
                txtBatsman1Four.text = batsmanFour.toString()
            }
            if(run==6) {
                var batsmanSix = txtBatsman1Six.text.toString().toInt()
                batsmanSix++
                txtBatsman1Six.text = batsmanSix.toString()
            }
            val sr = 100*batsmanRun/batsmanBall
            txtBatsman1SR.text = sr.toString()
        }
        else{
            var batsmanRun = txtBatsman2Run.text.toString().toInt()
            batsmanRun += run
            txtBatsman2Run.text = batsmanRun.toString()

            var batsmanBall = txtBatsman2Ball.text.toString().toInt()
            batsmanBall++
            txtBatsman2Ball.text = batsmanBall.toString()

            if(run==4) {
                var batsmanFour = txtBatsman2Four.text.toString().toInt()
                batsmanFour++
                txtBatsman2Four.text = batsmanFour.toString()
            }
            if(run==6) {
                var batsmanSix = txtBatsman2Six.text.toString().toInt()
                batsmanSix++
                txtBatsman2Six.text = batsmanSix.toString()
            }
            val sr = 100*batsmanRun/batsmanBall
            txtBatsman2SR.text = sr.toString()

        }
    }

}