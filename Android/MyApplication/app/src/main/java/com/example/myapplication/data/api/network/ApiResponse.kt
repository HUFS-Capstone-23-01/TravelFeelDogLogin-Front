package com.example.myapplication.data.api.network

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

sealed class ApiResponse<out T : Any?> {
    data class Success<out T : Any?>(val data: T) : ApiResponse<T>()
    data class Error(val errorBody: JSONObject) : ApiResponse<Nothing>()
    data class Failure(val message: String?) : ApiResponse<Nothing>()
    data class E(val e: Exception) : ApiResponse<Nothing>()
}

suspend fun <T : Any> handleApiRequest(
    errorMessage: String? = null,
    call: suspend () -> Call<T>
): ApiResponse<T> {
    try {
        val response = call()
        var result: ApiResponse<T>? = null

        response.enqueue(object: Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful) {
                    response.body()?.let { result = ApiResponse.Success(it) }
                }
                else {
                    response.errorBody()?.let { result = ApiResponse.Error(JSONObject(it.string())) }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                result = ApiResponse.Failure(t.message)
            }
        })
        result?.let { return it }
        return ApiResponse.E(NullPointerException())
    } catch (e: Exception) {
        return ApiResponse.E(RuntimeException(e.message))
    }
}