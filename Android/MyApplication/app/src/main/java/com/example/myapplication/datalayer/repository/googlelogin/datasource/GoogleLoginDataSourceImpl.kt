package com.example.myapplication.datalayer.repository.googlelogin.datasource

import com.example.myapplication.datalayer.api.LoginApi
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import retrofit2.Call
import retrofit2.Response

class GoogleLoginDataSourceImpl(private val loginApi: LoginApi): GoogleLoginDataSource {
    override suspend fun googleLoginForIdToken(
        request: GoogleLoginByIdTokenRequest
    ): Response<GoogleLoginResponse> {
        return loginApi.googleLoginForIdToken(request)
    }
}