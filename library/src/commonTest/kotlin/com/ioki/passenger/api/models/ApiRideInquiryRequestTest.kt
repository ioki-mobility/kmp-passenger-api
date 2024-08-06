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
                ),
                destination = ApiRideInquiryRequest.Location(
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
                ),
            ),
            rideInquiryRequest,
        )
    }
}

private val rideInquiryRequest =
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
        "time": "1970-01-01T00:00:00Z"
      },
  "destination": {}
}
"""
