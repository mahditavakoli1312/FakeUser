package com.example.createuser.data.datasource.remote.api

import com.example.core.data.URLs
import com.example.createuser.data.datasource.remote.model.FakeUserResponse
import retrofit2.Response
import retrofit2.http.GET

interface FakeUserApi {

    @GET(URLs.GET_USER)
    suspend fun createFakeUser(): Response<FakeUserResponse>
}