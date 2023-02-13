package com.example.createuser.data.datasource.local.db

interface PersonDataBase {
    fun personDao(): PersonDao
}