package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlin.test.Test

internal class ApiRideInquiryRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiRideInquiryRequest(
                productId = "prd_123",
                origin = ApiRideInquiryRequest.Location(
                    lat = 1.0,
                    lng = 2.0,
                    locationName = "location name",
                    streetName = "street name",
                    streetNumber = "17B",
                    postalCode = "12345",
                    city = "city",
                    county = "county",
                    country = "country",
                    time = Instant.parse("1970-01-01T00:00:00Z"),
                    stationId = "station id",
                ),
                destination = defaultApiLocation(),
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
            ),
            rideInquiryJson,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiRideInquiryRequest(
                productId = "prd_123",
                origin = ApiRideInquiryRequest.Location(
                    lat = 1.0,
                    lng = 2.0,
                    locationName = "location name",
                    streetName = "street name",
                    streetNumber = "17B",
                    postalCode = "12345",
                    city = "city",
                    county = "county",
                    country = "country",
                    time = Instant.parse("1970-01-01T00:00:00Z"),
                    stationId = "station id",
                ),
                destination = defaultApiLocation(),
                passengers = null,
            ),
            rideInquiryMinimalJson,
        )
    }
}

private fun defaultApiLocation(): ApiRideInquiryRequest.Location = ApiRideInquiryRequest.Location(
    lat = null,
    lng = null,
    locationName = null,
    streetName = null,
    streetNumber = null,
    postalCode = null,
    city = null,
    county = null,
    country = null,
    time = null,
    stationId = null,
)

private val rideInquiryMinimalJson =
    """
{
"product_id": "prd_123",
  "origin": {
        "lat": 1.0,
        "lng": 2.0,
        "location_name": "location name",
        "street_name": "street name",
        "street_number": "17B",
        "postal_code": "12345",
        "city": "city",
        "county": "county",
        "country": "country",
        "time": "1970-01-01T00:00:00Z",
        "station_id": "station id"
      },
  "destination": {}
}
"""

private val rideInquiryJson =
    """
{
"product_id": "prd_123",
  "origin": {
        "lat": 1.0,
        "lng": 2.0,
        "location_name": "location name",
        "street_name": "street name",
        "street_number": "17B",
        "postal_code": "12345",
        "city": "city",
        "county": "county",
        "country": "country",
        "time": "1970-01-01T00:00:00Z",
        "station_id": "station id"
      },
  "destination": {},
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
	]
}
"""
