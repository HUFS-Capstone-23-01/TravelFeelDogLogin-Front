package com.example.myapplication.data.model.googlelogin
import com.example.myapplication.data.model.auth.TokenResponse
import com.google.gson.annotations.SerializedName

data class GoogleLoginResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String
)
data class Data(
    @SerializedName("email")
    val email: String,
    @SerializedName("tokenResponse")
    val tokenResponse: TokenResponse,
    @SerializedName("type")
    val type: String
)