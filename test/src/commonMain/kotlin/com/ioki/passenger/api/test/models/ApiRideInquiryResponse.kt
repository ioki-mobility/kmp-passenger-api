package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiArea
import com.ioki.passenger.api.models.ApiRideInquiryResponse
import com.ioki.passenger.api.models.ApiRideInquiryResponse.Assistance.ErrorCode
import kotlin.time.Instant

public fun createApiRideInquiryResponse(
    availability: ApiRideInquiryResponse.Availability = createApiRideInquiryResponseAvailability(),
    constraints: ApiRideInquiryResponse.Constraints = createApiRideInquiryResponseConstraints(),
    assistances: List<ApiRideInquiryResponse.Assistance> = emptyList(),
): ApiRideInquiryResponse = ApiRideInquiryResponse(
    availability = availability,
    constraints = constraints,
    assistances = assistances,
)

public fun createApiRideInquiryResponseAvailability(
    available: Boolean = false,
    nextAvailability: Instant? = null,
): ApiRideInquiryResponse.Availability = ApiRideInquiryResponse.Availability(
    available = available,
    nextAvailability = nextAvailability,
)

public fun createApiRideInquiryResponseConstraints(area: ApiArea? = null): ApiRideInquiryResponse.Constraints =
    ApiRideInquiryResponse.Constraints(area = area)

public fun createApiRideInquiryResponseAssistance(
    title: String = "",
    text: String = "",
    href: String? = null,
    errorCode: ErrorCode? = null,
): ApiRideInquiryResponse.Assistance = ApiRideInquiryResponse.Assistance(
    title = title,
    text = text,
    href = href,
    errorCode = errorCode,
)
