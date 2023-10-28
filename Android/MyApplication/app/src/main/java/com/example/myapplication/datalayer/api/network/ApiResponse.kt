package com.example.myapplication.datalayer.api.network

import retrofit2.Response
import timber.log.Timber

sealed class ApiResponse<out T : Any?> {
    data class Success<out T : Any?>(val data: T) : ApiResponse<T>()
    data class Error(val e: Exception) : ApiResponse<Nothing>()
}

suspend fun <T : Any> handleApiRequest(
    errorMessage: String? = null,
    call: suspend () -> Response<T>
): ApiResponse<T> {
    try {
        val response = call()
        if (response.isSuccessful) {
            response.body()?.let { return ApiResponse.Success(it) }
        } else {
            response.errorBody()?.let { return ApiResponse.Error(RuntimeException(it.string())) }
        }
        return ApiResponse.Error(RuntimeException(errorMessage))
    } catch (e: Exception) {
        return ApiResponse.Error(Exception(e))
    }
}