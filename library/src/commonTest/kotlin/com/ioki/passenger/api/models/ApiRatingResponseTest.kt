package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRatingResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingResponse(
                id = "abc123",
                ratingLineItems = listOf(
                    ApiRatingLineItem(criterionSlug = "driver", value = 5),
                    ApiRatingLineItem(criterionSlug = "ride", value = 4),
                ),
                comment = "Nice comment",
            ),
            ratingResponse,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingResponse(
                id = "abc123",
                ratingLineItems = emptyList(),
                comment = null,
            ),
            ratingResponseMinimal,
        )
    }
}

private val ratingResponse =
    """
{
  "id": "abc123",
  "rating_line_items": [
    {
      "criterion_slug": "driver",
      "value": 5
    },
    {
      "criterion_slug": "ride",
      "value": 4
    }
  ],
  "comment": "Nice comment"
}
"""

private val ratingResponseMinimal =
    """
{
  "id": "abc123",
  "rating_line_items": []
}
"""
