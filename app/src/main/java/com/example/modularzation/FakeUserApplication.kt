package com.example.modularzation

import android.app.Application
import com.example.createuser.di.PersonDetailsInjector
import com.example.createuser.ui.PersonDetailsFragment
import com.example.modularzation.di.component.*

class FakeUserApplication : Application(), PersonDetailsInjector {
    private val contextComponent: ContextComponent by lazy {
        DaggerContextComponent.factory().create(this)
    }
    private val networkComponent: NetworkComponent by lazy {
        DaggerNetworkComponent.factory().create(contextComponent = contextComponent)
    }
    private val dataBaseComponent: AppDataBaseComponent by lazy {
        DaggerAppDataBaseComponent.factory().create(
            contextComponent
        )
    }
    private val createUserComponent: CreateUserComponent by lazy {
        DaggerCreateUserComponent.factory().create(
            networkComponent = networkComponent,
            appDataBaseComponent = dataBaseComponent
        )
    }

    override fun inject(fragment: PersonDetailsFragment) {
        createUserComponent.inject(fragment)
    }
}