package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiLocation
import com.ioki.passenger.api.models.ApiOfferedSolution
import com.ioki.passenger.api.models.ApiPublicTransportType
import com.ioki.passenger.api.models.ApiVehicle

public fun createApiOfferedSolution(
    type: String = "",
    id: String = "",
    bookable: Boolean = false,
    fare: ApiFareResponse? = null,
    hops: List<ApiOfferedSolution.Hop> = emptyList(),
): ApiOfferedSolution = ApiOfferedSolution(
    type = type,
    id = id,
    bookable = bookable,
    fare = fare,
    hops = hops,
)

public fun createApiOfferedSolutionHop(
    transportMode: ApiOfferedSolution.Hop.TransportMode = ApiOfferedSolution.Hop.TransportMode.UNSUPPORTED,
    from: ApiLocation = createApiLocation(),
    to: ApiLocation = createApiLocation(),
    track: String? = null,
    duration: Int = 0,
    vehicle: ApiVehicle? = null,
    details: ApiOfferedSolution.Hop.Details? = null,
): ApiOfferedSolution.Hop = ApiOfferedSolution.Hop(
    transportMode = transportMode,
    from = from,
    to = to,
    track = track,
    duration = duration,
    vehicle = vehicle,
    details = details,
)

public fun createApiOfferedSolutionHopDetails(
    direction: String? = null,
    name: String? = null,
    transportType: ApiPublicTransportType? = null,
): ApiOfferedSolution.Hop.Details = ApiOfferedSolution.Hop.Details(
    direction = direction,
    name = name,
    transportType = transportType,
)
