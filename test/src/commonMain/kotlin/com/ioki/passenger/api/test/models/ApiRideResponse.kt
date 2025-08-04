package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBookedSolution
import com.ioki.passenger.api.models.ApiBooking
import com.ioki.passenger.api.models.ApiBookingState
import com.ioki.passenger.api.models.ApiCancellationReason
import com.ioki.passenger.api.models.ApiDriver
import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiLocation
import com.ioki.passenger.api.models.ApiOfferedSolution
import com.ioki.passenger.api.models.ApiOption
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiRatingResponse
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiTipResponse
import com.ioki.passenger.api.models.ApiVehicle
import kotlin.time.Instant

public fun createApiRideResponse(
    id: String = "",
    productId: String = "",
    state: ApiBookingState = ApiBookingState.UNSUPPORTED,
    version: Int = 0,
    passengers: List<ApiRideResponse.PassengerSelection> = emptyList(),
    options: List<ApiOption> = emptyList(),
    cancellationReason: ApiCancellationReason? = null,
    vehicleApproachedPickup: Boolean = false,
    vehicleReachedPickup: Boolean = false,
    vehicleReachedDropoff: Boolean = false,
    validForPassengerUntil: Instant? = null,
    rateable: Boolean = false,
    rideSeriesId: String? = null,
    tippable: Boolean = false,
    cancellable: Boolean = false,
    needsCancellationCode: Boolean = false,
    cancellationReasonTranslated: String? = null,
    prebooked: Boolean = false,
    origin: ApiLocation = createApiLocation(),
    destination: ApiLocation = createApiLocation(),
    pickup: ApiLocation? = null,
    dropoff: ApiLocation? = null,
    vehicle: ApiVehicle? = null,
    driver: ApiDriver? = null,
    fare: ApiFareResponse? = null,
    booking: ApiBooking? = null,
    rating: ApiRatingResponse? = null,
    paymentMethod: ApiPaymentMethodResponse? = null,
    driverCanBeCalled: Boolean = false,
    publicTransportUri: String? = null,
    createdAt: Instant = Instant.DISTANT_PAST,
    route: ApiRideResponse.Route? = null,
    ticket: ApiRideResponse.Ticket? = null,
    tip: ApiTipResponse? = null,
    supportUri: String? = null,
    offeredSolutions: List<ApiOfferedSolution> = emptyList(),
    bookedSolution: ApiBookedSolution? = null,
    passengerNoteToDriver: String = "",
    showPublicTransportTicketReminder: Boolean = false,
): ApiRideResponse = ApiRideResponse(
    id = id,
    productId = productId,
    state = state,
    version = version,
    passengers = passengers,
    options = options,
    cancellationReason = cancellationReason,
    vehicleApproachedPickup = vehicleApproachedPickup,
    vehicleReachedPickup = vehicleReachedPickup,
    vehicleReachedDropoff = vehicleReachedDropoff,
    validForPassengerUntil = validForPassengerUntil,
    rateable = rateable,
    rideSeriesId = rideSeriesId,
    tippable = tippable,
    cancellable = cancellable,
    needsCancellationCode = needsCancellationCode,
    cancellationReasonTranslated = cancellationReasonTranslated,
    prebooked = prebooked,
    origin = origin,
    destination = destination,
    pickup = pickup,
    dropoff = dropoff,
    vehicle = vehicle,
    driver = driver,
    fare = fare,
    booking = booking,
    rating = rating,
    paymentMethod = paymentMethod,
    driverCanBeCalled = driverCanBeCalled,
    publicTransportUri = publicTransportUri,
    createdAt = createdAt,
    route = route,
    ticket = ticket,
    tip = tip,
    supportUri = supportUri,
    offeredSolutions = offeredSolutions,
    bookedSolution = bookedSolution,
    passengerNoteToDriver = passengerNoteToDriver,
    showPublicTransportTicketReminder = showPublicTransportTicketReminder,
)

public fun createApiRideResponsePassengerSelection(
    type: String = "",
    options: List<ApiOption> = emptyList(),
    firstName: String? = null,
    lastName: String? = null,
): ApiRideResponse.PassengerSelection = ApiRideResponse.PassengerSelection(
    type = type,
    options = options,
    firstName = firstName,
    lastName = lastName,
)

public fun createApiRideResponseRoute(track: String? = null): ApiRideResponse.Route =
    ApiRideResponse.Route(track = track)

public fun createApiRideResponseTicket(
    host: String? = null,
    mobileTicketData: List<ApiRideResponse.Ticket.MobileTicketData?>? = null,
    ticketUrl: String = "",
    issuer: String = "",
): ApiRideResponse.Ticket = ApiRideResponse.Ticket(
    host = host,
    mobileTicketData = mobileTicketData,
    ticketUrl = ticketUrl,
    issuer = issuer,
)
