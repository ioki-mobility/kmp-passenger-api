package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlin.test.Test

internal class ApiRedeemedPromoCodeResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiRedeemedPromoCodeResponse(
                id = "abc123",
                createdAt = Instant.parse("1970-01-01T00:00:00Z"),
                title = "title",
                description = "description",
                url = "https://my.url",
            ),
            redeemedPromoCode,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiRedeemedPromoCodeResponse(
                id = "abc123",
                createdAt = Instant.parse("1970-01-01T00:00:00Z"),
                title = "title",
                description = "description",
                url = null,
            ),
            redeemedPromoCodeMinimal,
        )
    }
}

private val redeemedPromoCode =
    """
{
  "id": "abc123",
  "created_at": "1970-01-01T00:00:00Z",
  "title": "title",
  "description": "description",
  "url": "https://my.url"
}
"""

private val redeemedPromoCodeMinimal =
    """
{
  "id": "abc123",
  "created_at": "1970-01-01T00:00:00Z",
  "title": "title",
  "description": "description"
}
"""
