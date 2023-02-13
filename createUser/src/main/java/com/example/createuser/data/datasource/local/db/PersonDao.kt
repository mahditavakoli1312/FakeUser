package com.example.createuser.data.datasource.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.createuser.data.datasource.local.model.PersonEntity

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPersons(personEntities: List<PersonEntity>)

    @Query("SELECT * FROM person ORDER BY id DESC LIMIT 1")
    suspend fun getLastPerson(): PersonEntity
}