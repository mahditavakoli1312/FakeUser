package com.example.createuser.data.datasource.local

import com.example.createuser.data.datasource.local.db.PersonDao
import com.example.createuser.data.datasource.local.model.PersonEntity
import javax.inject.Inject

class PersonDetailsLocalDataSourceImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonDetailsLocalDataSource {
    override suspend fun savePersons(persons: List<PersonEntity>) =
        personDao.insertPersons(
            personEntities = persons
        )

    override suspend fun getLastPersonAdded(): PersonEntity =
        personDao.getLastPerson()
}