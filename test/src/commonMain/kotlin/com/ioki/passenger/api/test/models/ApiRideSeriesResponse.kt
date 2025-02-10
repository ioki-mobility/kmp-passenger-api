package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiRideSeriesResponse
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

public fun createApiRideSeriesResponse(
    id: String = "",
    createdAt: Instant? = null,
    updatedAt: Instant = Instant.DISTANT_PAST,
    baseRideId: String = "",
    additionalDates: List<LocalDate> = emptyList(),
    processingFinishedAt: Instant? = null,
    rides: List<ApiRideResponse> = emptyList(),
    results: List<ApiRideSeriesResponse.Result> = emptyList(),
): ApiRideSeriesResponse = ApiRideSeriesResponse(
    id = id,
    createdAt = createdAt,
    updatedAt = updatedAt,
    baseRideId = baseRideId,
    additionalDates = additionalDates,
    processingFinishedAt = processingFinishedAt,
    rides = rides,
    results = results,
)

public fun createApiRideSeriesResponseResult(
    processed: Boolean = false,
    rideDate: LocalDate = LocalDate.fromEpochDays(0),
    rideId: String? = null,
    rideCreateSuccess: Boolean? = null,
    rideCreateErrorCode: String? = null,
    bookingSuccess: Boolean? = null,
    bookingErrorCode: String? = null,
): ApiRideSeriesResponse.Result = ApiRideSeriesResponse.Result(
    processed = processed,
    rideDate = rideDate,
    rideId = rideId,
    rideCreateSuccess = rideCreateSuccess,
    rideCreateErrorCode = rideCreateErrorCode,
    bookingSuccess = bookingSuccess,
    bookingErrorCode = bookingErrorCode,
)
