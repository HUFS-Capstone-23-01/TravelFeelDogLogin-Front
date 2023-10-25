package com.example.myapplication.data.model

data class TokenLoginResponse(
    val email: String,
    val type: String,
    val token: TokenResponse
)

