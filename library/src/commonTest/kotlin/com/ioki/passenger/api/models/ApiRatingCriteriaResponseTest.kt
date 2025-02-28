package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiRatingCriteriaResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiRatingCriteriaResponse(
                type = ApiRatingCriteriaResponse.Type.RATING_CRITERION,
                slug = "driver",
                localizedName = "Rating Criterion",
                localizedDescription = "Rating Criterion Desc",
                default = true,
            ),
            jsonString = RATING_CRITERIA,
        )
    }

    @Test
    fun unsupported_serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiRatingCriteriaResponse(
                type = ApiRatingCriteriaResponse.Type.UNSUPPORTED,
                slug = "ride",
                localizedName = "",
                localizedDescription = "",
                default = true,
            ),
            jsonString = UNSUPPORTED,
        )
    }
}

private const val RATING_CRITERIA =
    """
{
  "slug":"driver",
  "default": true,
  "localized_name":"Rating Criterion",
  "localized_description":"Rating Criterion Desc",
  "type": "rating_criterion"
}
"""

private const val UNSUPPORTED =
    """
{
  "slug":"ride",
  "default": true,
  "localized_name":"",
  "localized_description":"",
  "type": "not_supported"
}
"""
