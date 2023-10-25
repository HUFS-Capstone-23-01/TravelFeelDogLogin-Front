package com.example.myapplication.data.model.googlelogin

import com.google.gson.annotations.SerializedName

data class GoogleLoginByIdTokenRequest(
    @SerializedName("token")
    val token: String
)

