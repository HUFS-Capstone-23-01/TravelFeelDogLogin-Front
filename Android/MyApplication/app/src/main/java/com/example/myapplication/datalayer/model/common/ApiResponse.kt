package com.example.myapplication.datalayer.model.common
data class ApiResponse<T>(
    val body: T?,
    val message: String?
)