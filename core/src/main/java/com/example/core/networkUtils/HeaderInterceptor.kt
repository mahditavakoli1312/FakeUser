package com.example.core.networkUtils


import okhttp3.Interceptor
import okhttp3.Response


class HeaderInterceptor private constructor() : Interceptor {

    companion object {
        private val lock = Any()

        @Volatile
        private var instance: HeaderInterceptor? = null

        @Synchronized
        fun getInstance(): HeaderInterceptor {
            return instance ?: synchronized(lock) {
                return instance ?: HeaderInterceptor().also {
                    instance = it
                }
            }
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        chain.run {
            val requestBuilder = request().newBuilder()
            return chain.proceed(requestBuilder.build())
        }
    }
}


