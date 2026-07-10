package com.ioki.passenger.api.models

import kotlin.test.Test
import kotlin.time.Instant

internal class ApiUserLocationTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocation(
                id = "user_loc_123",
                version = 1,
                title = "Home",
                locationType = ApiUserLocation.Type.HOME,
                lat = 52.5200,
                lng = 13.4050,
                locationName = "Berlin Central Station",
                streetName = "Europaplatz",
                streetNumber = "1",
                postalCode = "10557",
                city = "Berlin",
                county = "Berlin",
                country = "Germany",
                formattedAddress = "Europaplatz 1, 10557 Berlin, Germany",
                type = "address",
                time = Instant.parse("2026-07-09T12:00:00Z"),
                waypointType = "pickup",
                stationId = "station_456",
                walkingDuration = 300,
                walkingTrack = "encoded_polyline_string",
                station = null,
                displayTimes = listOf(Instant.parse("2026-07-09T12:00:00Z"), Instant.parse("2026-07-09T12:30:00Z")),
            ),
            userLocation,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiUserLocation(
                id = "123",
                version = 1,
                title = "Home",
                locationType = ApiUserLocation.Type.HOME,
                lat = 52.520008,
                lng = 13.404954,
                locationName = null,
                streetName = null,
                streetNumber = null,
                postalCode = null,
                city = null,
                county = null,
                country = null,
                formattedAddress = "Berlin, Germany",
                type = null,
                time = null,
                waypointType = null,
                stationId = null,
                walkingDuration = null,
                walkingTrack = null,
                station = null,
                displayTimes = listOf(),
            ),
            userLocationMinimal,
        )
    }
}

private val userLocation: String =
    """
        {
            "id": "user_loc_123",
            "version": 1,
            "title": "Home",
            "locationType": "HOME",
            "lat": 52.5200,
            "lng": 13.4050,
            "location_name": "Berlin Central Station",
            "street_name": "Europaplatz",
            "street_number": "1",
            "postal_code": "10557",
            "city": "Berlin",
            "county": "Berlin",
            "country": "Germany",
            "formatted_address": "Europaplatz 1, 10557 Berlin, Germany",
            "type": "address",
            "time": "2026-07-09T12:00:00Z",
            "waypoint_type": "pickup",
            "station_id": "station_456",
            "walking_duration": 300,
            "walking_track": "encoded_polyline_string",
            "station": null,
            "display_times": ["2026-07-09T12:00:00Z", "2026-07-09T12:30:00Z"]
        }
    """.trimIndent()
private val userLocationMinimal: String =
    """
        {
            "id": "123",
            "version": 1,
            "title": "Home",
            "locationType": "HOME",
            "lat": 52.520008,
            "lng": 13.404954,
            "formatted_address": "Berlin, Germany",
            "display_times": []
        }
    """.trimIndent()
