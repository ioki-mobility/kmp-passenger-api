package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdateUserNotificationSettingsRequest(
    val name: String,
    val channels: List<ApiNotificationChannelType>,
)
