package com.example.createuser.data.datasource.remote.model

data class InfoResponse(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)