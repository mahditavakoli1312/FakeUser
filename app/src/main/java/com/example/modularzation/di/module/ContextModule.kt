package com.example.modularzation.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    fun provideContext(FakeUserApplication: com.example.modularzation.FakeUserApplication): Context {
        return FakeUserApplication.applicationContext
    }

    @Provides
    fun provideApplication(FakeUserApplication: com.example.modularzation.FakeUserApplication): Application {
        return FakeUserApplication
    }
}