package com.example.createuser.data.repository

import com.example.core.networkUtils.safeApiCall
import com.example.createuser.data.datasource.remote.FakeUserRemoteDataSource
import com.example.createuser.data.datasource.remote.model.FakeUserResponse
import javax.inject.Inject

class FakeUserRepositoryImpl @Inject constructor(
    private val fakeUserRemoteDataSource: FakeUserRemoteDataSource
) : FakeUserRepository {
    override suspend fun createFakeUser(): com.example.core.networkUtils.ResultWrapper<FakeUserResponse> =
        safeApiCall {
            fakeUserRemoteDataSource.getFakeUser()
        }

}