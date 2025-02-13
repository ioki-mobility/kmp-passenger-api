package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRideOptions

public fun createApiRideOptions(
    passengers: ApiRideOptions.Passenger = createApiRideOptionsPassenger(),
    destinationTimeBasedMatching: Boolean = false,
    preBookingThreshold: ApiRideOptions.PreBookingThreshold? = createApiRideOptionsPreBookingThreshold(),
): ApiRideOptions = ApiRideOptions(
    passengers = passengers,
    destinationTimeBasedMatching = destinationTimeBasedMatching,
    preBookingThreshold = preBookingThreshold,
)

public fun createApiRideOptionsPassenger(
    nameRequiredIfNoPublicTransportTicket: Boolean = false,
): ApiRideOptions.Passenger = ApiRideOptions.Passenger(
    nameRequiredIfNoPublicTransportTicket = nameRequiredIfNoPublicTransportTicket,
)

public fun createApiRideOptionsPreBookingThreshold(
    minSeconds: Int = 0,
    maxSeconds: Int = 0,
): ApiRideOptions.PreBookingThreshold = ApiRideOptions.PreBookingThreshold(
    minSeconds = minSeconds,
    maxSeconds = maxSeconds,
)
