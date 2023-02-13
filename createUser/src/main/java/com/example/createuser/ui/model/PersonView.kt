package com.example.createuser.ui.model

import com.example.createuser.data.datasource.local.model.PersonEntity

data class PersonView(
    val idValue: String? = "-1",
    val email: String? = null,
    val gender: String? = null,
    val city: String? = null,
    val country: String? = null,
    val postcode: String? = null,
    val state: String? = null,
    val streetName: String? = null,
    val streetNumber: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val nameTitle: String? = null,
    val phone: String? = null,
    val largePicture: String? = null,
    val latLocation: String? = null,
    val longLocation: String? = null,
    val dobAge: String? = null
)

fun PersonEntity.toPersonView() =
    PersonView(
        idValue = idValue,
        email = email,
        gender = gender,
        city = city,
        country = country,
        postcode = postcode,
        state = state,
        streetName = streetName,
        streetNumber = streetNumber,
        firstName = firstName,
        lastName = lastName,
        nameTitle = nameTitle,
        phone = phone,
        largePicture = largePicture,
        latLocation = latitude,
        longLocation = longitude,
        dobAge = dobAge
    )