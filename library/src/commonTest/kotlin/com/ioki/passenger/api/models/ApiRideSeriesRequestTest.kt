package com.ioki.passenger.api.models

import kotlinx.datetime.LocalDate
import kotlin.test.Test

internal class ApiRideSeriesRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiRideSeriesRequest(
                additionalDates = listOf(
                    LocalDate.parse("2019-06-18"),
                ),
            ),
            rideSeriesRequest,
        )
    }
}

private val rideSeriesRequest =
    """
{
  "additional_dates": ["2019-06-18"]
}
"""
