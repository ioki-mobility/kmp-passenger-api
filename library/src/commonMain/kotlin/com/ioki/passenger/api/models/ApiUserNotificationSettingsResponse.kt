package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiUserNotificationSettingsResponse(
    val id: String,
    val type: String,
    val name: String,
    val channels: List<ApiNotificationChannelType>,
)
