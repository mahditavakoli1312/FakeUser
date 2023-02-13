package com.example.createuser.data.datasource.remote.model

data class LocationResponse(

    val coordinates: CoordinatesResponse,
    val city: String,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: TimezoneResponse
)