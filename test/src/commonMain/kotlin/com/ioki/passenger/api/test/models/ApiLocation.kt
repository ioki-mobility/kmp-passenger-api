package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiLocation
import com.ioki.passenger.api.models.ApiStationResponse
import kotlinx.datetime.Instant

public fun createApiLocation(
    lat: Double = 0.0,
    lng: Double = 0.0,
    locationName: String? = null,
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
    type: String? = null,
    time: Instant? = null,
    waypointType: String? = null,
    stationId: String? = null,
    walkingDuration: Long? = null,
    walkingTrack: String? = null,
    station: ApiStationResponse? = null,
    displayTimes: List<Instant> = emptyList(),
): ApiLocation = ApiLocation(
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
    type = type,
    time = time,
    waypointType = waypointType,
    stationId = stationId,
    walkingDuration = walkingDuration,
    walkingTrack = walkingTrack,
    station = station,
    displayTimes = displayTimes,
)
