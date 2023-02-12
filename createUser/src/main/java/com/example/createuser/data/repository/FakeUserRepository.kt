package com.example.createuser.data.repository

import com.example.createuser.data.datasource.remote.model.FakeUserResponse

interface FakeUserRepository {
    suspend fun createFakeUser(): com.example.core.networkUtils.ResultWrapper<FakeUserResponse>
}