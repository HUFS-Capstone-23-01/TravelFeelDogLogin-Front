package com.example.myapplication.data.model.common
data class ApiResponse<T>(
    val body: T?,
    val message: String?
)