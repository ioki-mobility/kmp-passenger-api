package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiNotificationChannelType
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest

public fun createApiUpdateUserNotificationSettingsRequest(
    name: String = "",
    channels: List<ApiNotificationChannelType> = emptyList(),
): ApiUpdateUserNotificationSettingsRequest = ApiUpdateUserNotificationSettingsRequest(
    name = name,
    channels = channels,
)
