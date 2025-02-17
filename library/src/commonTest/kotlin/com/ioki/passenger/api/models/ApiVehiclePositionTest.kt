package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiVehiclePositionTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiVehiclePosition(lat = 49.012, lng = 8.245, heading = 123.0f),
            vehiclePosition,
        )
    }
}

private val vehiclePosition =
    """
{
  "heading":123.0,
  "lat": 49.012,
  "lng": 8.245
}
"""
