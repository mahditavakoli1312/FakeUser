package com.example.createuser.data.repository

import android.util.Log
import com.example.createuser.data.datasource.remote.FakeUserRemoteDataSource
import com.example.createuser.data.datasource.remote.model.FakeUserResponse
import javax.inject.Inject

class FakeUserRepositoryImpl @Inject constructor(
    private val fakeUserRemoteDataSource: FakeUserRemoteDataSource
) : FakeUserRepository {
    override suspend fun createFakeUser(): FakeUserResponse {
        val res = fakeUserRemoteDataSource.getFakeUser()
        Log.d("mahdi", "repository createFakeUser: $res")
        return res
    }
}