package com.example.myapplication.data.model
data class ApiResponse<T>(
    val body: T?,
    val message: String?
)