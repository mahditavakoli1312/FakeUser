package com.example.createuser.data.datasource.remote.model

data class LocationResponse(
    val city: String,
    val coordinates: CoordinatesResponse,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: TimezoneResponse
)