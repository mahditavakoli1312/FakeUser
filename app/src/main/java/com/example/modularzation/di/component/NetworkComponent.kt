package com.example.modularzation.di.component

import com.example.modularzation.di.module.NetworkModule
import com.example.modularzation.di.scope.NetworkScope
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit

@NetworkScope
@Component(
    modules = [
        NetworkModule::class
    ],
    dependencies = [
        ContextComponent::class,
    ]
)

interface NetworkComponent {

    fun retrofit(): Retrofit
    fun gson(): Gson

    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent
        ): NetworkComponent
    }
}