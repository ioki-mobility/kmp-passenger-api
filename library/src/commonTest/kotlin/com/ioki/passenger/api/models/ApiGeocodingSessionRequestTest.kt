package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiGeocodingSessionRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSessionRequest(
                productId = "prd_123",
            ),
            jsonString = session,
        )
    }
}

private val session =
    """
{
    "product_id": "prd_123"
}
"""
