package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRideSeriesResponse(
    val id: String,
    @SerialName(value = "created_at") val createdAt: Instant?,
    @SerialName(value = "updated_at") val updatedAt: Instant,
    @SerialName(value = "base_ride_id") val baseRideId: String,
    @SerialName(value = "additional_dates") val additionalDates: List<LocalDate>,
    @SerialName(value = "processing_finished_at") val processingFinishedAt: Instant?,
    val rides: List<ApiRideResponse>,
    val results: List<Result>,
) {
    @Serializable
    public data class Result(
        val processed: Boolean,
        @SerialName(value = "ride_date") val rideDate: LocalDate,
        @SerialName(value = "ride_id") val rideId: String?,
        @SerialName(value = "ride_create_success") val rideCreateSuccess: Boolean?,
        @SerialName(value = "ride_create_error_code") val rideCreateErrorCode: String?,
        @SerialName(value = "booking_success") val bookingSuccess: Boolean?,
        @SerialName(value = "booking_error_code") val bookingErrorCode: String?,
    )
}
