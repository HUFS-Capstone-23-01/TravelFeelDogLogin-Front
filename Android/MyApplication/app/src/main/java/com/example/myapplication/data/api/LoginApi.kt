package com.example.myapplication.data.api

import com.example.myapplication.data.model.ApiResponse
import com.example.myapplication.data.model.TokenLoginRequest
import com.example.myapplication.data.model.TokenLoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("/login/mobile/oauth2/google/token")
    suspend fun mobileGoogleAuthenticationLogin(
        @Body request: TokenLoginRequest
    ): Call<ApiResponse<TokenLoginResponse>>
}
