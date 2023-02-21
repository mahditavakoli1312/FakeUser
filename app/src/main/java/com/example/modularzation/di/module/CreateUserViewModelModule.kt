package com.example.modularzation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core.common.ApplicationViewModelFactory
import com.example.createuser.ui.PersonDetailsViewModel
import com.example.modularzation.di.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CreateUserViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ApplicationViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PersonDetailsViewModel::class)
    abstract fun bindPersonDetailsViewModel(viewModel: PersonDetailsViewModel): ViewModel
}