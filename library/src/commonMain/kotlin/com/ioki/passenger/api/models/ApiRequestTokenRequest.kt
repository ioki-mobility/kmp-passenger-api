package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRequestTokenRequest(
    @SerialName(value = "phone_number") val phoneNumber: String,
    val code: String,
)
