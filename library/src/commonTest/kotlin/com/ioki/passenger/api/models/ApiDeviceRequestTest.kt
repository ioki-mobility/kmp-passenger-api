package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDeviceRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiDeviceRequest(token = "abc123"),
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
