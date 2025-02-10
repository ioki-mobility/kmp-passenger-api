package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAddress

public fun createApiAddress(
    locationName: String = "",
    streetName: String = "",
    streetNumber: String = "",
    postalCode: String = "",
    city: String = "",
    county: String = "",
    country: String = "",
): ApiAddress = ApiAddress(
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
)
