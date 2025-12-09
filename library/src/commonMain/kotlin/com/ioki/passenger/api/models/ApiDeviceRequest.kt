package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiDeviceRequest(
    val token: String,
    @SerialName(value = "supports_encrypted_notifications") val supportsEncryptedNotifications: Boolean,
    @SerialName(value = "supports_fetching_notifications") val supportsFetchingNotifications: Boolean,
)
