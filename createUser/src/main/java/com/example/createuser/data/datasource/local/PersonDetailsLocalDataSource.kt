package com.example.createuser.data.datasource.local

import com.example.createuser.data.datasource.local.model.PersonEntity

interface PersonDetailsLocalDataSource {
    suspend fun savePersons(persons: List<PersonEntity>)
    suspend fun getLastPersonAdded(): PersonEntity
}