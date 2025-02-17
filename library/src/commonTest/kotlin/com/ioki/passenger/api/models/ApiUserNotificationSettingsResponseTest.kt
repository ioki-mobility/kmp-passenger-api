package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUserNotificationSettingsResponseTest : IokiApiModelTest() {
    @Test
    fun serializationNoChannels() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiUserNotificationSettingsResponse(
                id = "ride_notifications",
                type = "notification_settings",
                name = "ride_notifications",
                channels = emptyList(),
            ),
            jsonString = userNotificationSettingsResponseNoChannels,
        )
    }

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiUserNotificationSettingsResponse(
                id = "ride_notifications",
                type = "notification_settings",
                name = "ride_notifications",
                channels = listOf(ApiNotificationChannelType.SMS),
            ),
            jsonString = userNotificationSettingsResponse,
        )
    }
}

private val userNotificationSettingsResponseNoChannels =
    """
{
  "id": "ride_notifications",
  "type": "notification_settings",
  "name": "ride_notifications",
  "channels": []
}
    """

private val userNotificationSettingsResponse =
    """
{
  "id": "ride_notifications",
  "type": "notification_settings",
  "name": "ride_notifications",
  "channels": ["sms"]
}
    """
