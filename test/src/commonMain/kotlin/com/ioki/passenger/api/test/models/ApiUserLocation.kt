package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiStationResponse
import com.ioki.passenger.api.models.ApiUserLocation
import com.ioki.passenger.api.models.ApiUserLocation.Type
import kotlin.time.Instant

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
    formattedAddress: String = "",
    type: String? = null,
    time: Instant? = null,
    waypointType: String? = null,
    stationId: String? = null,
    walkingDuration: Long? = null,
    walkingTrack: String? = null,
    station: ApiStationResponse? = null,
    displayTimes: List<Instant> = emptyList(),
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
    formattedAddress = formattedAddress,
    type = type,
    time = time,
    waypointType = waypointType,
    stationId = stationId,
    walkingDuration = walkingDuration,
    walkingTrack = walkingTrack,
    station = station,
    displayTimes = displayTimes,
)
