package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiBookingResponse(
    val id: String,
    @SerialName(value = "verification_code") val verificationCode: String,
)
