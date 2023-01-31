package com.example.core.networkUtils

import com.example.core.data.ConstanceValue
import com.google.gson.Gson

fun <T> retrofit2.Response<T>.bodyOrThrow(): T {
    if (isSuccessful)
        return body() ?: throw NullPointerException()
    else {
        val gson = Gson()
        val errorBody = errorBody()?.string()
        val errorMessage: String = try {
            val errors = gson.fromJson(errorBody, ErrorsResponse::class.java).message
            if (errors != null)
                errors[0] ?: ""
            else ConstanceValue.FAILURE
        } catch (e: Exception) {
            gson.fromJson(errorBody, ErrorResponse::class.java).message
        }
        throw NetworkException(
            serverMessage = errorMessage, code = code()
        )
    }
}