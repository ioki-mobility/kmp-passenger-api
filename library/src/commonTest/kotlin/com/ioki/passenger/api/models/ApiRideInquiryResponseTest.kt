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
                    drtArea = PassengerApiArea(
                        type = "",
                        id = "",
                        name = "",
                        slug = "",
                        areaType = "",
                        color = "",
                        opacity = 0.5f,
                        strokeWeight = 1,
                        fillColor = "",
                        fillOpacity = 0.5f,
                        invert = false,
                        zIndex = 0,
                        legendIndex = 0,
                        legendTitle = null,
                        legendDescription = null,
                        area = ApiArea("", emptyList()),
                    ),
                    maxPassengers = 1,
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
    "max_passengers": 1,
    "area": {
      "type": "MultiPolygon",
      "coordinates": []
    },
    "drt_area": {
      "type": "",
      "id": "",
      "name": "",
      "slug": "",
      "area_type": "",
      "color": "",
      "opacity": 0.5,
      "stroke_weight": 1,
      "fill_color": "",
      "fill_opacity": 0.5,
      "invert": false,
      "z_index": 0,
      "legend_index": 0,
      "area": {
        "type": "",
        "coordinates": []
      }
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
