package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiGeocodingSearchRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiGeocodingSearchRequest(
                query = "Hauptwache",
                productId = "prd_123",
                placeTypes = "a,b,c",
            ),
            jsonString = search,
        )
    }
}

private val search =
    """
{
    "query": "Hauptwache",
    "product_id": "prd_123",
    "place_types": "a,b,c"
}
"""
