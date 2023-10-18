package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var authorizationText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val googleLoginButton = findViewById<Button>(R.id.googleLoginButton)
        authorizationText = findViewById(R.id.authorizationText)

        googleLoginButton.setOnClickListener {
            // 구글 로그인 페이지 열기
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://localhost:8080/oauth2/authorization/google"))
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            if (uri.toString().startsWith("http://localhost:8080/")) {
                val authorization = uri.getQueryParameter("Authorization")
                authorizationText.text = authorization ?: "No Authorization found"
            }
        }
    }
}
