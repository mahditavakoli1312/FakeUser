package com.example.createuser.data.repository

import com.example.core.networkUtils.safeApiCall
import com.example.createuser.data.datasource.local.PersonDetailsLocalDataSource
import com.example.createuser.data.datasource.local.model.PersonEntity
import com.example.createuser.data.datasource.local.model.toPersonEntity
import com.example.createuser.data.datasource.remote.FakeUserRemoteDataSource
import javax.inject.Inject

class FakeUserRepositoryImpl @Inject constructor(
    private val fakeUserRemoteDataSource: FakeUserRemoteDataSource,
    private val personDetailsLocalDataSource: PersonDetailsLocalDataSource
) : FakeUserRepository {
    override suspend fun createFakeUser(): com.example.core.networkUtils.ResultWrapper<PersonEntity> =
        safeApiCall {
            val response = fakeUserRemoteDataSource.getFakeUser()
            personDetailsLocalDataSource.savePersons(
                listOf(response.results.first().toPersonEntity())
            )
            personDetailsLocalDataSource.getLastPersonAdded()
            return@safeApiCall personDetailsLocalDataSource.getLastPersonAdded()
        }
}