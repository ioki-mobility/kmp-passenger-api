package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse
import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse.VendorType

public fun createApiGeocodingDetailsResponse(
    id: String = "",
    vendor: String = "",
    vendorId: String = "",
    lat: Double = 0.0,
    lng: Double = 0.0,
    vendorType: VendorType = VendorType.UNSUPPORTED,
    locationName: String? = null,
    formattedAddress: String? = null,
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
): ApiGeocodingDetailsResponse = ApiGeocodingDetailsResponse(
    id = id,
    lat = lat,
    lng = lng,
    vendor = vendor,
    vendorId = vendorId,
    vendorType = vendorType,
    locationName = locationName,
    formattedAddress = formattedAddress,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
)
