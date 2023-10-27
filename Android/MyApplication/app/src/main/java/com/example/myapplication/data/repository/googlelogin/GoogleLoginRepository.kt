package com.example.myapplication.data.repository.googlelogin

import com.example.myapplication.data.model.auth.TokenResponse
import com.example.myapplication.data.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.data.model.googlelogin.GoogleLoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

interface GoogleLoginRepository {
    suspend fun googleLoginForIdToken(
        idToken: String
    ): Call<GoogleLoginResponse>
}