package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiAddress(
    val locationName: String,
    val streetName: String,
    val streetNumber: String,
    val postalCode: String,
    val city: String,
    val county: String,
    val country: String,
)
