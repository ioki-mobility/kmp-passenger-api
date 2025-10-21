package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingSearchResponse
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult.Vendor
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse.SearchResult.ResultType
import kotlin.String

public fun createApiGeocodingSearchResponse(results: List<SearchResult> = emptyList()): ApiGeocodingSearchResponse =
    ApiGeocodingSearchResponse(results = results)

public fun createApiGeocodingSearchResponseSearchResult(
    id: String = "",
    vendor: Vendor = Vendor.UNSUPPORTED,
    resultType: ResultType = ResultType.DEFAULT,
    vendorId: String = "",
    lat: Double? = null,
    lng: Double? = null,
    locationName: String? = null,
    formattedAddress: String? = null,
    description: String? = null,
): SearchResult = SearchResult(
    id = id,
    lat = lat,
    lng = lng,
    resultType = resultType,
    vendor = vendor,
    vendorId = vendorId,
    locationName = locationName,
    formattedAddress = formattedAddress,
    description = description,
)
