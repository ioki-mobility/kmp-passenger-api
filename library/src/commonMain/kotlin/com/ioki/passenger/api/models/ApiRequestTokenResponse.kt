package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRequestTokenResponse(
    val id: String,
    val type: String,
    val token: String,
    @SerialName(value = "user_id") val userId: String,
)
