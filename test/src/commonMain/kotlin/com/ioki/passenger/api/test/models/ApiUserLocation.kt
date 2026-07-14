package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiUserLocation
import com.ioki.passenger.api.models.ApiUserLocation.Type

public fun createApiUserLocation(
    id: String = "",
    version: Int = 1,
    title: String = "",
    locationType: Type = Type.OTHER,
    lat: Double = 0.0,
    lng: Double = 0.0,
    locationName: String? = null,
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
    editableByUser: Boolean = false,
    userId: String = "",
    customFlags: List<ApiUserLocation.CustomFlag> = emptyList(),
): ApiUserLocation = ApiUserLocation(
    id = id,
    version = version,
    title = title,
    locationType = locationType,
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
    editableByUser = editableByUser,
    userId = userId,
    customFlags = customFlags,
)

public fun createCustomFlag(slug: String = "", name: String = ""): ApiUserLocation.CustomFlag =
    ApiUserLocation.CustomFlag(
        slug = slug,
        name = name,
    )
