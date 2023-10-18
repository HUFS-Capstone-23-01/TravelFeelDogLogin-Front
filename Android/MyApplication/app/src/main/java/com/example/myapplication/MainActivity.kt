package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var authorizationText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val googleLoginButton = findViewById<Button>(R.id.googleLoginButton)
        authorizationText = findViewById(R.id.authorizationText)
        Log.d("AuthorizationLog","NOT")
        googleLoginButton.setOnClickListener {
            // 구글 로그인 페이지 열기
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://sunghyun98.com/oauth2/authorization/google"))
            startActivity(intent)
        }
    }
//https://sunghyun98.com/?Authorization=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqbzE4NzcxMkBnbWFpbC5jb20iLCJpYXQiOjE2OTc1OTU5NDQsImV4cCI6MTY5NzU5NjI0NH0.NwFCqUnpz52aLTgRVETgsq1SHktTKGEc2CM5FG9LGLU
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        intent?.data?.let { uri ->
            if (uri.toString().startsWith("http://sunghyun98.com/")) {
                val authorization = uri.getQueryParameter("Authorization")

                // 콘솔에 Authorization 값을 출력
                Log.d("AuthorizationLog", "Authorization: $authorization")

                // 새로운 액티비티를 시작하고 Authorization 값을 전달합니다.
                val authorizationIntent = Intent(this, AuthorizationActivity::class.java).apply {
                    putExtra("Authorization", authorization)
                }
                //http://localhost:8080/oauth2/authorization/google
                startActivity(authorizationIntent)
            }
        }
    }

}
