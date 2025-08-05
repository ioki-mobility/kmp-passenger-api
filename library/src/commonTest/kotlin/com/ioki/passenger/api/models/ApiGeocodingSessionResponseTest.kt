package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.time.Instant

internal class ApiGeocodingSessionResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSessionResponse(
                id = "abc123",
                createdAt = Instant.parse(input = "2023-07-19T13:17:42Z"),
                updatedAt = Instant.parse(input = "2023-07-20T13:17:42Z"),
                validUntil = Instant.parse(input = "2023-07-29T00:00:00Z"),
            ),
            jsonString = session,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSessionResponse(
                id = "abc123",
                createdAt = Instant.parse(input = "2023-07-19T13:17:42Z"),
                updatedAt = null,
                validUntil = Instant.parse(input = "2023-07-29T00:00:00Z"),
            ),
            jsonString = sessionMinimal,
        )
    }
}

private val session =
    """
{
    "id": "abc123",
    "created_at": "2023-07-19T13:17:42Z",
    "updated_at": "2023-07-20T13:17:42Z",
    "valid_until": "2023-07-29T00:00:00Z"
}
"""

private val sessionMinimal =
    """
{
    "id": "abc123",
    "created_at": "2023-07-19T13:17:42Z",
    "valid_until": "2023-07-29T00:00:00Z"
}
"""
