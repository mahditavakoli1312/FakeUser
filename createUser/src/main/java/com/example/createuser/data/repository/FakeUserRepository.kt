package com.example.createuser.data.repository

import com.example.createuser.data.datasource.local.model.PersonEntity

interface FakeUserRepository {
    suspend fun createFakeUser(): com.example.core.networkUtils.ResultWrapper<PersonEntity>
}