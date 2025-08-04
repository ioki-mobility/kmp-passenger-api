package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlin.test.Test

internal class ApiRideInquiryResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiRideInquiryResponse(
                availability = ApiRideInquiryResponse.Availability(
                    available = true,
                    nextAvailability = Instant.parse("1970-01-01T00:00:00Z"),
                ),
                constraints = ApiRideInquiryResponse.Constraints(
                    area = ApiArea("MultiPolygon", emptyList()),
                ),
                assistances = listOf(
                    ApiRideInquiryResponse.Assistance(
                        title = "title",
                        text = "text",
                        href = "http://url",
                        errorCode = ApiRideInquiryResponse.Assistance.ErrorCode.SERVICE_NOT_AVAILABLE,
                    ),
                    ApiRideInquiryResponse.Assistance(
                        title = "title2",
                        text = "text2",
                        href = null,
                        errorCode = null,
                    ),
                    ApiRideInquiryResponse.Assistance(
                        title = "title3",
                        text = "text3",
                        href = null,
                        errorCode = ApiRideInquiryResponse.Assistance.ErrorCode.UNSUPPORTED,
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
      "error_code": "service_not_available"
    },
    {
      "title": "title2",
      "text": "text2"
    },
    {
      "title": "title3",
      "text": "text3"
      "error_code": "unknown"
    }
  ]
}
"""
