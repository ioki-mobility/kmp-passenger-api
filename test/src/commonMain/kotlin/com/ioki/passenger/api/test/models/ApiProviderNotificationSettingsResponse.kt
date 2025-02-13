package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiNotificationChannelType
import com.ioki.passenger.api.models.ApiProviderNotificationSettingsResponse

public fun createApiProviderNotificationSettingsResponse(
    id: String = "",
    type: String = "",
    name: String = "",
    channels: List<ApiNotificationChannelType> = emptyList(),
): ApiProviderNotificationSettingsResponse = ApiProviderNotificationSettingsResponse(
    id = id,
    type = type,
    name = name,
    channels = channels,
)
