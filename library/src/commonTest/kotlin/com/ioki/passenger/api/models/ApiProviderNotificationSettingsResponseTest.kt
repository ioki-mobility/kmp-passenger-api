package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiProviderNotificationSettingsResponseTest : IokiApiModelTest() {
    @Test
    fun serializationNoChannels() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiProviderNotificationSettingsResponse(
                id = "ride_notifications",
                type = "notification_settings",
                name = "ride_notifications",
                channels = emptyList(),
            ),
            jsonString = providerNotificationSettingsResponseNoChannels,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiProviderNotificationSettingsResponse(
                id = "ride_notifications",
                type = "notification_settings",
                name = "ride_notifications",
                channels = listOf(ApiNotificationChannelType.SMS),
            ),
            jsonString = providerNotificationSettingsResponse,
        )
    }
}

private val providerNotificationSettingsResponseNoChannels =
    """
{
  "id": "ride_notifications",
  "type": "notification_settings",
  "name": "ride_notifications",
  "channels": []
}
    """

private val providerNotificationSettingsResponse =
    """
{
  "id": "ride_notifications",
  "type": "notification_settings",
  "name": "ride_notifications",
  "channels": ["sms"]
}
    """
