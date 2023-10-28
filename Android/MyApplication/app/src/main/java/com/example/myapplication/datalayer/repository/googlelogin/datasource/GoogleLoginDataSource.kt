package com.example.myapplication.datalayer.repository.googlelogin.datasource

import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import retrofit2.Call
import retrofit2.Response

interface GoogleLoginDataSource {
    suspend fun googleLoginForIdToken(
        request: GoogleLoginByIdTokenRequest
    ): Response<GoogleLoginResponse>
}