package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDeviceResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiDeviceResponse(
                id = "dev_857dd1b4-8a06-4a8e-8b2c-c123c4293283",
                token = "abc123",
            ),
            deviceResponse,
        )
    }
}

private val deviceResponse =
    """
{
  "id": "dev_857dd1b4-8a06-4a8e-8b2c-c123c4293283",
  "token": "abc123"
}
"""
