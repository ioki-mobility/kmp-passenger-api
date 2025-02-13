package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiLocation
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.expect

internal class ApiLocationTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            model = ApiLocation(
                lat = 50.104558,
                lng = 8.649113,
                locationName = "DB Office Center",
                streetName = "Mainzer Landstrasse",
                streetNumber = "199",
                postalCode = "60326",
                city = "Frankfurt am Main",
                county = "Hessen",
                country = "Germany",
                type = "requested_point",
                time = Instant.parse("2017-09-06T15:13:43Z"),
                waypointType = "dropoff",
                stationId = "sta_463fb145-7850-47e8-96c0-5126de5c3191",
                walkingDuration = 234,
                walkingTrack = "_iajH_oyo@_pR_pR_pR_pR_pR_pR_pR_pR",
                displayTimes = listOf(
                    Instant.parse("2019-06-18T12:00:00Z"),
                    Instant.parse("2019-06-18T12:10:00Z"),
                ),
                station = null,
            ),
            jsonString = location,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            createApiLocation(
                lat = 50.104558,
                lng = 8.649113,
                locationName = "DB Office Center",
            ),
            locationMinimal,
        )
    }

    @Test
    fun `location hasDifferentPoint with stationId returns true`() {
        val location = createApiLocation(stationId = "stationId")

        expect(location.hasDifferentPoint) { true }
    }

    @Test
    fun `location hasDifferentPoint without stationId without walkingDuration returns false`() {
        val location = createApiLocation(
            stationId = null,
            walkingDuration = null,
        )

        expect(location.hasDifferentPoint) { false }
    }

    @Test
    fun `location hasDifferentPoint without stationId with walkingDuration zero returns false`() {
        val location = createApiLocation(
            stationId = null,
            walkingDuration = 0,
        )

        expect(location.hasDifferentPoint) { false }
    }

    @Test
    fun `location hasDifferentPoint without stationId with walkingDuration greater zero returns true`() {
        val location = createApiLocation(
            stationId = null,
            walkingDuration = 500,
        )

        expect(location.hasDifferentPoint) { true }
    }
}

private val location =
    """
{
  "lat": 50.104558,
  "lng": 8.649113,
  "location_name": "DB Office Center",
  "street_name": "Mainzer Landstrasse",
  "street_number": "199",
  "postal_code": "60326",
  "city": "Frankfurt am Main",
  "county": "Hessen",
  "country": "Germany",
  "type": "requested_point",
  "time": "2017-09-06T15:13:43Z",
  "waypoint_type": "dropoff",
  "station_id": "sta_463fb145-7850-47e8-96c0-5126de5c3191",
  "walking_duration": 234,
  "walking_track": "_iajH_oyo@_pR_pR_pR_pR_pR_pR_pR_pR",
  "display_times": ["2019-06-18T12:00:00Z", "2019-06-18T12:10:00Z"]
}
"""

private val locationMinimal =
    """
{
  "lat": 50.104558,
  "lng": 8.649113,
  "location_name": "DB Office Center",
  "display_times": []
}
"""
