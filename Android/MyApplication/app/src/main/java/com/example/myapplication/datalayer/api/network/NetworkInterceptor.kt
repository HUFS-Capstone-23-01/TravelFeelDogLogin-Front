package com.example.myapplication.datalayer.api.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain
            .request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .build()
        return chain.proceed(builder)
    }

}