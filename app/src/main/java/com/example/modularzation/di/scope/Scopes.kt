package com.example.modularzation.di.scope

import javax.inject.Scope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PersonDetailsScope

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ContextScope