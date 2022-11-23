package com.uttamsaha.kheloindia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var etUserId : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtForgotPassword : TextView
    lateinit var btnSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUserId = findViewById(R.id.etUserId)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)

        btnSignUp.setOnClickListener{
            val intent = Intent(this@LoginActivity,SigninActivity::class.java)
            startActivity(intent)
        }
    }
}