package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDeviceRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiDeviceRequest(token = "abc123"),
            jsonString = deviceRequest,
        )
    }
}

private val deviceRequest =
    """
{
  "token": "abc123"
}
"""
