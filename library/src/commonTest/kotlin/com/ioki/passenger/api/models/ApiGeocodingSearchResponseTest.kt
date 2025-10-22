package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult.ResultType
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult.Vendor
import kotlin.test.Test

internal class ApiGeocodingSearchResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSearchResponse(
                results = listOf(
                    SearchResult(
                        id = "abc123",
                        lat = 50.113695,
                        lng = 8.678996,
                        locationName = "Hauptwache",
                        resultType = ResultType.DEFAULT,
                        vendor = Vendor.IOKI,
                        vendorId = "vendor_123",
                        formattedAddress = "Hauptwache, Frankfurt am Main, Germany",
                        description = "description_a",
                    ),
                ),
            ),
            jsonString = search,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSearchResponse(
                results = listOf(
                    SearchResult(
                        id = "abc123",
                        resultType = ResultType.POI,
                        vendor = Vendor.IOKI,
                        vendorId = "vendor_123",
                        lat = null,
                        lng = null,
                        locationName = null,
                        description = null,
                        formattedAddress = null,
                    ),
                ),
            ),
            jsonString = searchMinimal,
        )
    }
}

private val search =
    """
{
    "results": [
        {
            "id": "abc123",
            "lat": 50.113695,
            "lng": 8.678996,
            "result_type": "default",
            "vendor": "ioki",
            "vendor_id": "vendor_123",
            "location_name": "Hauptwache",
            "formatted_address": "Hauptwache, Frankfurt am Main, Germany",
            "description": "description_a"
        }
    ]
}
"""

private val searchMinimal =
    """
{
    "results": [
        {
            "id": "abc123",
            "result_type": "poi",
            "vendor": "ioki",
            "vendor_id": "vendor_123"
        }
    ]
}
"""
