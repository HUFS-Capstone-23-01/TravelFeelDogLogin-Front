package com.example.myapplication.datalayer.api

import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/login/web/oauth2/google/idToken")
    suspend fun googleLoginForIdToken(
        @Body request: GoogleLoginByIdTokenRequest
    ): Response<GoogleLoginResponse>
}
