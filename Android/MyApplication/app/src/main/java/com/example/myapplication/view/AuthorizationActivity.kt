package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class AuthorizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        val authorizationDisplayText = findViewById<TextView>(R.id.authorizationDisplayText)
        val authorization = intent.getStringExtra("Authorization")
        authorizationDisplayText.text = authorization ?: "No Authorization found"
    }
}
