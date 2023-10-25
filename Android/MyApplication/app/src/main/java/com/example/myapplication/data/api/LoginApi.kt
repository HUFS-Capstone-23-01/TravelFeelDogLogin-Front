package com.example.myapplication.data.api

import com.example.myapplication.data.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.data.model.googlelogin.GoogleLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/login/mobile/oauth2/google")
    suspend fun googleLoginForIdToken(
        @Body request: GoogleLoginByIdTokenRequest
    ): Call<GoogleLoginResponse>
}
