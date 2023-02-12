package com.example.createuser.data.datasource.remote.impl

import com.example.core.networkUtils.bodyOrThrow
import com.example.createuser.data.datasource.remote.FakeUserRemoteDataSource
import com.example.createuser.data.datasource.remote.api.FakeUserApi
import com.example.createuser.data.datasource.remote.model.FakeUserResponse
import javax.inject.Inject

class FakeUserRemoteDataSourceImpl @Inject constructor(
    private val fakeUserApi: FakeUserApi
) : FakeUserRemoteDataSource {
    override suspend fun getFakeUser(): FakeUserResponse =
        fakeUserApi.createFakeUser().bodyOrThrow()


}