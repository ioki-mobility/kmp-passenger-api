package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRatingRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingRequest(
                rideVersion = 2,
                ratingLineItems = listOf(
                    ApiRatingLineItem(
                        criterionSlug = "driver",
                        value = 5,
                    ),
                    ApiRatingLineItem(
                        criterionSlug = "ride",
                        value = 4,
                    ),
                ),
                comment = "Nice comment",
            ),
            ratingRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiRatingRequest(
                rideVersion = 2,
                ratingLineItems = emptyList(),
                comment = null,
            ),
            ratingRequestMinimal,
        )
    }
}

private val ratingRequest =
    """
{
  "ride_version": 2,
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

private val ratingRequestMinimal =
    """
{
  "ride_version": 2,
  "rating_line_items": []
}
"""
