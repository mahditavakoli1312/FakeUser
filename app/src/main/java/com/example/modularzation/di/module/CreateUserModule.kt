package com.example.modularzation.di.module

import com.example.createuser.data.datasource.remote.FakeUserRemoteDataSource
import com.example.createuser.data.datasource.remote.api.FakeUserApi
import com.example.createuser.data.datasource.remote.impl.FakeUserRemoteDataSourceImpl
import com.example.createuser.data.repository.FakeUserRepository
import com.example.createuser.data.repository.FakeUserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class CreateUserModule {
    @Binds
    abstract fun bindFakeRemoteUserDataSource(
        impl: FakeUserRemoteDataSourceImpl
    ): FakeUserRemoteDataSource

    @Binds
    abstract fun bindFakeRepository(
        impl: FakeUserRepositoryImpl
    ): FakeUserRepository

    companion object {
        @Provides
        fun provideFakeUserApi(retrofit: Retrofit): FakeUserApi =
            retrofit.create(FakeUserApi::class.java)
    }
}