package com.example.myapplication.datalayer.model.googlelogin
import com.example.myapplication.datalayer.model.auth.TokenResponse
import com.google.gson.annotations.SerializedName

data class GoogleLoginResponse(
    @SerializedName("data")
    val `data`: Data?,
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