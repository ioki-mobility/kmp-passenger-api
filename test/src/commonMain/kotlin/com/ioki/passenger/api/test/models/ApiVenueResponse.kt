package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiVenueResponse

public fun createApiVenueResponse(
    id: String = "",
    city: String = "",
    county: String = "",
    country: String = "",
    formattedStreet: String = "",
    lat: Double = 0.0,
    lng: Double = 0.0,
    locationName: String? = null,
    postalCode: String? = null,
    productId: String = "",
    streetName: String? = null,
    streetNumber: String? = null,
    venueType: ApiVenueResponse.VenueType = ApiVenueResponse.VenueType.OTHER,
): ApiVenueResponse = ApiVenueResponse(
    id = id,
    city = city,
    county = county,
    country = country,
    formattedStreet = formattedStreet,
    lat = lat,
    lng = lng,
    locationName = locationName,
    postalCode = postalCode,
    productId = productId,
    streetName = streetName,
    streetNumber = streetNumber,
    venueType = venueType,
)
