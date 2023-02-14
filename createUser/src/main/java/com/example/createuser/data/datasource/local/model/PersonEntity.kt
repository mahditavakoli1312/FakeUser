package com.example.createuser.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.createuser.data.datasource.remote.model.ResultResponse

@Entity(tableName = "person")

data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val idValue: String = "",
    val email: String? = null,
    val gender: String? = null,
    val city: String,
    val country: String,
    val postcode: String,
    val state: String,
    val streetName: String,
    val streetNumber: Int,
    val firstName: String,
    val lastName: String,
    val nameTitle: String,
    val phone: String? = null,
    val largePicture: String,
    val latitude: String? = "",
    val dobAge: String? = "",
    val longitude: String? = ""
)

fun ResultResponse.toPersonEntity() =
    PersonEntity(
        idValue = id?.value ?: "-2",
        email = email,
        gender = gender,
        city = location?.city ?: "",
        country = location?.country ?: "",
        postcode = location?.postcode ?: "",
        state = location?.state ?: "",
        streetName = location?.street?.name ?: "",
        streetNumber = location?.street?.number ?: -2,
        firstName = name?.first ?: "",
        lastName = name?.last ?: "",
        nameTitle = name?.title ?: "",
        phone = phone,
        largePicture = picture?.large ?: "",
        latitude = location?.coordinates?.latitude ?: "",
        dobAge = dob?.age ?: "",
        longitude = location?.coordinates?.longitude ?: ""
    )

fun emptyPerson() =
    PersonEntity(
        idValue = "-2",
        email = "email",
        gender = "gender",
        city = "",
        country = "",
        postcode = "",
        state = "",
        streetName = "",
        streetNumber = -2,
        firstName = "",
        lastName = "",
        nameTitle = "",
        phone = "phone",
        largePicture = "",
        latitude = "",
        dobAge = "",
        longitude = ""

    )