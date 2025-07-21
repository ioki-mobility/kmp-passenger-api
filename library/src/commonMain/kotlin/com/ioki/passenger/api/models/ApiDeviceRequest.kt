package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiDeviceRequest(
    val token: String,
    @SerialName(value = supports_encrypted_notifications) val supportsEncryptedNotifications: Boolean,
)
