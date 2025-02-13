package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiPublicTransportType
import com.ioki.passenger.api.models.ApiStationResponse

public fun createApiStationResponse(
    id: String = "",
    lat: Double = 0.0,
    lng: Double = 0.0,
    locationName: String = "",
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
    description: String? = null,
    avatar: ApiAvatar? = null,
    publicTransportTypes: List<ApiPublicTransportType>? = null,
    publicTransportScheduleUrl: String? = null,
    visibleOnMap: Boolean = false,
): ApiStationResponse = ApiStationResponse(
    id = id,
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
    description = description,
    avatar = avatar,
    publicTransportTypes = publicTransportTypes,
    publicTransportScheduleUrl = publicTransportScheduleUrl,
    visibleOnMap = visibleOnMap,
)
