package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiGeocodingDetailsRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingDetailsRequest(id = "id_123"),
            jsonString = details,
        )
    }
}

private val details =
    """
{
    "id": "id_123"
}
"""
