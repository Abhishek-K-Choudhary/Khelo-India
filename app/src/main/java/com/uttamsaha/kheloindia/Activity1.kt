package com.uttamsaha.kheloindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity1 : AppCompatActivity() {

    lateinit var btnHost : Button
    lateinit var btnVisitor : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        btnHost = findViewById(R.id.btnHost)
        btnVisitor = findViewById(R.id.btnVisitor)

        btnHost.setOnClickListener{
            val intent = Intent(this@Activity1,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}