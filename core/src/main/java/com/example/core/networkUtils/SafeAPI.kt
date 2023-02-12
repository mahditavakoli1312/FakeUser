package com.example.core.networkUtils


suspend fun <T> safeApiCall(api: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Success(data = api.invoke())
    } catch (exception: Exception) {
        when (exception) {
            is NetworkException -> {
                ResultWrapper.Failure(
                    message = exception.serverMessage,
                    code = exception.code,
                )
            }
            else -> {
                ResultWrapper.ApplicationError(
                    message = exception.localizedMessage ,
                )
            }
        }
    }
}