package com.example.modularzation.di.component

import android.app.Application
import android.content.Context
import com.example.modularzation.di.module.ContextModule
import com.example.modularzation.di.scope.ContextScope
import dagger.BindsInstance
import dagger.Component

@ContextScope
@Component(
    modules = [ContextModule::class]
)
interface ContextComponent {

    fun context(): Context
    fun application(): Application

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: com.example.modularzation.FakeUserApplication
        ): ContextComponent
    }
}
