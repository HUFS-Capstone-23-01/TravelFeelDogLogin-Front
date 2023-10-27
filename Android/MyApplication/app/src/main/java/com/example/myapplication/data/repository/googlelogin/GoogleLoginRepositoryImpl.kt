package com.example.myapplication.data.repository.googlelogin

import com.example.myapplication.data.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.data.model.googlelogin.GoogleLoginResponse
import com.example.myapplication.data.repository.googlelogin.datasource.GoogleLoginDataSource
import retrofit2.Call
import retrofit2.Response

class GoogleLoginRepositoryImpl(private val dataSource: GoogleLoginDataSource): GoogleLoginRepository {
    override suspend fun googleLoginForIdToken(
        idToken: String
    ): Call<GoogleLoginResponse> {
        return dataSource.googleLoginForIdToken(GoogleLoginByIdTokenRequest(idToken))
    }
}