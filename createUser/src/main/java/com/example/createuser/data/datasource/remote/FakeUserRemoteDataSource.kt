package com.example.createuser.data.datasource.remote

import com.example.createuser.data.datasource.remote.model.FakeUserResponse

interface FakeUserRemoteDataSource {
    suspend fun getFakeUser() : FakeUserResponse
}