package com.example.myapplication.data.repository.googlelogin.datasource

import com.example.myapplication.data.api.LoginApi
import com.example.myapplication.data.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.data.model.googlelogin.GoogleLoginResponse
import retrofit2.Call

class GoogleLoginDataSourceImpl(private val loginApi: LoginApi): GoogleLoginDataSource {
    override suspend fun googleLoginForIdToken(
        request: GoogleLoginByIdTokenRequest
    ): Call<GoogleLoginResponse> {
        return loginApi.googleLoginForIdToken(request)
    }
}