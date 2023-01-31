package com.example.createuser.data.datasource.remote.model

data class ResultResponse(
    val cell: String? = null,
    val dob: DobResponse? = null,
    val email: String? = null,
    val gender: String? = null,
    val id: IdResponse? = null,
    val location: LocationResponse? = null,
    val login: LoginResponse? = null,
    val name: NameResponse? = null,
    val nat: String? = null,
    val phone: String? = null,
    val picture: PictureResponse? = null,
    val registered: RegisteredResponse? = null
)