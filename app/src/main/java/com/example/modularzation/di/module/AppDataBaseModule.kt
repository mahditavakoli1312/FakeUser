package com.example.modularzation.di.module

import android.content.Context
import androidx.room.Room
import com.example.modularzation.data.db.AppDataBase
import com.example.modularzation.di.scope.AppDataBaseScope
import dagger.Module
import dagger.Provides

@Module
object AppDataBaseModule {

    @Provides
    @AppDataBaseScope
    internal fun provideAppDataBase(
        context: Context
    ): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "fake_user"
    )
        .fallbackToDestructiveMigration()
        .build()
}