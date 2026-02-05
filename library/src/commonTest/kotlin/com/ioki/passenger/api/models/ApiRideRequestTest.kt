package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiLocation
import kotlin.test.Test

internal class ApiRideRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiRideRequest(
                productId = "abc-123",
                passengers = listOf(
                    ApiPassengerSelectionRequest(
                        type = "adult",
                        options = listOf(
                            ApiOption(
                                slug = "wheelchair",
                                value = AnyValue.BooleanValue(false),
                            ),
                            ApiOption(
                                slug = "bahncard",
                                value = AnyValue.BooleanValue(false),
                            ),
                            ApiOption(
                                slug = "walker",
                                value = AnyValue.BooleanValue(true),
                            ),
                            ApiOption(
                                slug = "public_transport_ticket",
                                value = AnyValue.BooleanValue(true),
                            ),
                            ApiOption(
                                slug = "blue_badge",
                                value = AnyValue.BooleanValue(false),
                            ),
                        ),
                        firstName = null,
                        lastName = null,
                    ),
                    ApiPassengerSelectionRequest(
                        type = "child",
                        options = listOf(
                            ApiOption(
                                slug = "wheelchair",
                                value = AnyValue.BooleanValue(true),
                            ),
                            ApiOption(
                                slug = "bahncard",
                                value = AnyValue.BooleanValue(true),
                            ),
                            ApiOption(
                                slug = "walker",
                                value = AnyValue.BooleanValue(false),
                            ),
                            ApiOption(
                                slug = "public_transport_ticket",
                                value = AnyValue.BooleanValue(false),
                            ),
                            ApiOption(
                                slug = "blue_badge",
                                value = AnyValue.BooleanValue(true),
                            ),
                        ),
                        firstName = null,
                        lastName = null,
                    ),
                ),
                options = listOf(
                    ApiOption(
                        slug = "storage_spaces",
                        value = AnyValue.IntValue(1),
                    ),
                ),
                origin = createApiLocation(
                    lat = 50.104692,
                    lng = 8.644062,
                    formattedAddress = "Galluswarte",
                ),
                destination = createApiLocation(
                    lat = 50.113695,
                    lng = 8.678996,
                    formattedAddress = "Hauptwache",
                ),
                driverNote = null,
            ),
            jsonString = rideRequest,
        )
    }
}

private val rideRequest =
    """
{
  "product_id": "abc-123",
	"passengers": [
      {
        "type": "adult",
        "options": [
          {
            "slug": "wheelchair",
            "value": false
          },
          {
            "slug": "bahncard",
            "value": false
          },
          {
            "slug": "walker",
            "value": true
          },
          {
            "slug": "public_transport_ticket",
            "value": true
          },
          {
            "slug": "blue_badge",
            "value": false
          }
        ]
      },
      {
        "type": "child",
        "options": [
          {
            "slug": "wheelchair",
            "value": true
          },
          {
            "slug": "bahncard",
            "value": true
          },
          {
            "slug": "walker",
            "value": false
          },
          {
            "slug": "public_transport_ticket",
            "value": false
          },
          {
            "slug": "blue_badge",
            "value": true
          }
        ]
      }
	],
  "options": [
    {
      "slug": "storage_spaces",
      "value": 1
    }
  ],
  "origin": {
    "lat": 50.104692,
    "lng": 8.644062,
    "formatted_address": "Galluswarte",
    "display_times": []
  },
  "destination": {
    "lat": 50.113695,
    "lng": 8.678996,
    "formatted_address": "Hauptwache",
    "display_times": []
  }
}
"""
