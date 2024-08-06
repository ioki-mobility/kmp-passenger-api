package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUpdateUserNotificationSettingsRequestTest : IokiApiModelTest() {
    @Test
    fun serializationNoChannels() {
        testSerializationWithJsonString(
            model = ApiUpdateUserNotificationSettingsRequest(
                name = "ride_notifications",
                channels = emptyList(),
            ),
            jsonString = updateUserNotificationSettingsRequestNoChannels,
        )
    }

    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiUpdateUserNotificationSettingsRequest(
                name = "ride_notifications",
                channels = listOf(ApiNotificationChannelType.SMS),
            ),
            jsonString = updateUserNotificationSettingsRequest,
        )
    }
}

private val updateUserNotificationSettingsRequestNoChannels =
    """
{
  "name": "ride_notifications",
  "channels": []
}
    """

private val updateUserNotificationSettingsRequest =
    """
{
  "name": "ride_notifications",
  "channels": ["sms"]
}
    """
