package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var authorizationText: TextView
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("651227713817-ruvfg1kslkhf6r6v2qobs667397hlkp3.apps.googleusercontent.com") // Replace with your server's client ID
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val googleLoginButton = findViewById<Button>(R.id.googleLoginButton)
        authorizationText = findViewById(R.id.authorizationText)

        googleLoginButton.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account?.idToken

            if (idToken != null) {
                sendTokenToServer(idToken)
            }

        } catch (e: ApiException) {
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        }
    }

    private fun sendTokenToServer(token: String) {
        val apiService = Retrofit.Builder()
            .baseUrl("https://sunghyun98.com/login/mobile/oauth2/google") // Replace with your Spring Boot Base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.mobileGoogleAuthenticationLogin(TokenLoginRequest(token))

            if (response.isSuccessful) {
                val responseBody = response.body()
                Log.d(TAG, "AccessToken: ${responseBody?.body?.token?.accessToken}")
                Log.d(TAG, "RefreshToken: ${responseBody?.body?.token?.refreshToken}")
            } else {
                Log.e(TAG, "Failed to authenticate with token: ${response.errorBody()}")
            }
        }
    }


    companion object {
        private const val RC_SIGN_IN = 9001
        private const val TAG = "MainActivity"
    }

}
