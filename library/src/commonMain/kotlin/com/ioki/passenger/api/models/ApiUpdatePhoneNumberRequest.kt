package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdatePhoneNumberRequest(
    @SerialName(value = "phone_number") val phoneNumber: String,
    val code: String,
)
