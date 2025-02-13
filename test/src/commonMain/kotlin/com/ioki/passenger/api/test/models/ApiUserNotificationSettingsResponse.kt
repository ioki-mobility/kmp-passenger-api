package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiNotificationChannelType
import com.ioki.passenger.api.models.ApiUserNotificationSettingsResponse

public fun createApiUserNotificationSettingsResponse(
    id: String = "",
    type: String = "",
    name: String = "",
    channels: List<ApiNotificationChannelType> = emptyList(),
): ApiUserNotificationSettingsResponse = ApiUserNotificationSettingsResponse(
    id = id,
    type = type,
    name = name,
    channels = channels,
)
