package com.example.modularzation.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.createuser.data.datasource.local.db.PersonDataBase
import com.example.createuser.data.datasource.local.model.PersonEntity

@Database(
    entities = [PersonEntity::class], version = 1
)
abstract class AppDataBase : RoomDatabase(), PersonDataBase