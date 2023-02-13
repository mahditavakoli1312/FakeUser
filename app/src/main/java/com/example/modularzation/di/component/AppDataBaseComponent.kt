package com.example.modularzation.di.component

import com.example.modularzation.data.db.AppDataBase
import com.example.modularzation.di.module.AppDataBaseModule
import com.example.modularzation.di.scope.AppDataBaseScope
import dagger.Component

@AppDataBaseScope
@Component(
    modules = [
        AppDataBaseModule::class
    ],
    dependencies = [
        ContextComponent::class
    ]
)
interface AppDataBaseComponent {
    fun appDataBase(): AppDataBase

    @Component.Factory
    interface Factory {
        fun create(
            component: ContextComponent
        ): AppDataBaseComponent
    }

}