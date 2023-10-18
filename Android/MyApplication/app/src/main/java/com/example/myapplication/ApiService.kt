package com.example.myapplication

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/login/mobile/oauth2/google/token")
    suspend fun mobileGoogleAuthenticationLogin(@Body request: TokenLoginRequest): Response<ApiResponse<TokenLoginResponse>>
}
