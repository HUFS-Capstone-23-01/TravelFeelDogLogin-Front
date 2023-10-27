package com.example.myapplication.data.repository.googlelogin.datasource

import com.example.myapplication.data.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.data.model.googlelogin.GoogleLoginResponse
import retrofit2.Call

interface GoogleLoginDataSource {
    suspend fun googleLoginForIdToken(
        request: GoogleLoginByIdTokenRequest
    ): Call<GoogleLoginResponse>
}