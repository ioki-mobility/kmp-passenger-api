package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPassengerSelectionRequest
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import kotlinx.datetime.Instant

public fun createApiRideInquiryRequest(
    productId: String = "",
    origin: ApiRideInquiryRequest.Location = createApiRideInquiryRequestLocation(),
    destination: ApiRideInquiryRequest.Location = createApiRideInquiryRequestLocation(),
    passengers: List<ApiPassengerSelectionRequest>? = null,
): ApiRideInquiryRequest = ApiRideInquiryRequest(
    productId = productId,
    origin = origin,
    destination = destination,
    passengers = passengers,
)

public fun createApiRideInquiryRequestLocation(
    lat: Double? = null,
    lng: Double? = null,
    locationName: String? = null,
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
    time: Instant? = null,
    stationId: String? = null,
): ApiRideInquiryRequest.Location = ApiRideInquiryRequest.Location(
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
    time = time,
    stationId = stationId,
)
