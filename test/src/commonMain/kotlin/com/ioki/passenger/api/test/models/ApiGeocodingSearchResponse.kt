package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingSearchResponse
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult
import kotlin.String

public fun createApiGeocodingSearchResponse(results: List<SearchResult> = emptyList()): ApiGeocodingSearchResponse =
    ApiGeocodingSearchResponse(results = results)

public fun createApiGeocodingSearchResponseSearchResult(
    id: String = "",
    vendor: String = "",
    vendorId: String = "",
    lat: Double = 0.0,
    lng: Double = 0.0,
    locationName: String? = null,
    formattedAddress: String? = null,
    description: String? = null,
): SearchResult = SearchResult(
    id = id,
    lat = lat,
    lng = lng,
    vendor = vendor,
    vendorId = vendorId,
    locationName = locationName,
    formattedAddress = formattedAddress,
    description = description,
)
