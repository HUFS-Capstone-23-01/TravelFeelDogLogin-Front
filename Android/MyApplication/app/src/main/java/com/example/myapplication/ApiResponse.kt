package com.example.myapplication
data class ApiResponse<T>(
    val body: T?,
    val message: String?
)