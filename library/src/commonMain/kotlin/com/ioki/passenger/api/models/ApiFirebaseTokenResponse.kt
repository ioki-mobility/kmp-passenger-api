package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiFirebaseTokenResponse(
    val jwt: String,
    @SerialName(value = "encryption_key") val encryptionKey: String,
)
