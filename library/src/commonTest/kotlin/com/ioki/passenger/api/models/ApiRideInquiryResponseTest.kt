package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlin.test.Test

internal class ApiRideInquiryResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiRideInquiryResponse(
                availability = ApiRideInquiryResponse.Availability(
                    available = true,
                    nextAvailability = Instant.parse("1970-01-01T00:00:00Z"),
                ),
                constraints = ApiRideInquiryResponse.Constraints(
                    area = ApiArea("MultiPolygon", emptyList()),
                ),
                errors = listOf("service_not_available"),
                assistances = listOf(
                    ApiRideInquiryResponse.Assistance(
                        title = "title",
                        text = "text",
                        href = "http://url",
                    ),
                    ApiRideInquiryResponse.Assistance(
                        title = "title2",
                        text = "text2",
                        href = null,
                    ),
                ),
            ),
            rideInquiryResponse,
        )
    }
}

private val rideInquiryResponse =
    """
{
  "availability": {
    "available": true,
    "next_availability": "1970-01-01T00:00:00Z"
  },
  "constraints": {
    "area": {
      "type": "MultiPolygon",
      "coordinates": []
    }
  },
  "errors": [
    "service_not_available"
  ],
  "assistances": [
    {
      "title": "title",
      "text": "text",
      "href": "http://url"
    },
    {
      "title": "title2",
      "text": "text2"
    }
  ]
}
"""
