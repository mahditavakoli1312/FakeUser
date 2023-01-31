package com.example.modularzation.di.component

import com.example.createuser.di.PersonDetailsInjector
import com.example.modularzation.di.module.CreateUserModule
import com.example.modularzation.di.module.CreateUserViewModelModule
import com.example.modularzation.di.scope.PersonDetailsScope
import dagger.Component

@PersonDetailsScope
@Component(
    modules = [
        CreateUserModule::class,
        CreateUserViewModelModule::class
    ],
    dependencies = [
        NetworkComponent::class
    ]
)
interface CreateUserComponent : PersonDetailsInjector {
    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent
        ): CreateUserComponent
    }
}