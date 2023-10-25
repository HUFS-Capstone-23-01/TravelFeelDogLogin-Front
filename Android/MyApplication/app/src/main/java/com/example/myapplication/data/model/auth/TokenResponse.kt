package com.example.myapplication.data.model.auth

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)
