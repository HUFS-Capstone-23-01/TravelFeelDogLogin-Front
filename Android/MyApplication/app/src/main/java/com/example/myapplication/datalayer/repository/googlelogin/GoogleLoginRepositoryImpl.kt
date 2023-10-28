package com.example.myapplication.datalayer.repository.googlelogin

import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginByIdTokenRequest
import com.example.myapplication.datalayer.model.googlelogin.GoogleLoginResponse
import com.example.myapplication.datalayer.repository.googlelogin.datasource.GoogleLoginDataSource
import retrofit2.Call
import retrofit2.Response

class GoogleLoginRepositoryImpl(private val dataSource: GoogleLoginDataSource): GoogleLoginRepository {
    override suspend fun googleLoginForIdToken(
        idToken: String
    ): Response<GoogleLoginResponse> {
        return dataSource.googleLoginForIdToken(GoogleLoginByIdTokenRequest(idToken))
    }
}