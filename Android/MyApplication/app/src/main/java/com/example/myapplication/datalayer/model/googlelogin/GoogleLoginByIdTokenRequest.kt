package com.example.myapplication.datalayer.model.googlelogin

import com.google.gson.annotations.SerializedName

data class GoogleLoginByIdTokenRequest(
    @SerializedName("token")
    val token: String
)

