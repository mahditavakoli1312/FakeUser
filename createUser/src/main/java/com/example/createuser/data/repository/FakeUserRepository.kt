package com.example.createuser.data.repository

import com.example.createuser.data.datasource.remote.model.FakeUserResponse

interface FakeUserRepository  {
    suspend fun createFakeUser() : FakeUserResponse
}