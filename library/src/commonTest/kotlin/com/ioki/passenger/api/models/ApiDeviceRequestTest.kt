package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDeviceRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiDeviceRequest(
                token = "abc123",
                supportsEncryptedNotifications = true,
                supportsFetchingNotifications = true,
            ),
            jsonString = deviceRequest,
        )
    }
}

private val deviceRequest =
    """
{
  "token": "abc123"
  "supports_encrypted_notifications": true,
  "supports_fetching_notifications": true
}
"""
