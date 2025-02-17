package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUserFlagsRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiUserFlagsRequest(
                version = 0,
                termsAccepted = true,
                minimumAgeConfirmed = true,
                analyticsTracking = true,
            ),
            userFlags,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiUserFlagsRequest(
                version = 0,
                termsAccepted = true,
                minimumAgeConfirmed = null,
                analyticsTracking = null,
            ),
            userFlagsMinimal,
        )
    }
}

private val userFlags =
    """
{
  "version": 0,
  "terms_accepted": true,
  "minimum_age_confirmed": true,
  "analytics_tracking": true
}
"""

private val userFlagsMinimal =
    """
{
  "version": 0,
  "terms_accepted": true
}
"""
