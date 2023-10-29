package com.example.myapplication.datalayer.repository.googlelogin

import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import retrofit2.Call
import retrofit2.Response

interface GoogleLoginRepository {
    suspend fun googleLoginForIdToken(
        idToken: String
    ): Response<GoogleLoginResponse>
}