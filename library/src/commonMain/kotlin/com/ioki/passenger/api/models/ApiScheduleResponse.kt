package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiScheduleResponse(
    @SerialName(value = "transport_type")
    val transportType: ApiPublicTransportType = ApiPublicTransportType.UNSUPPORTED,
    @SerialName(value = "direction")
    val direction: String,
    @SerialName(value = "name")
    val name: String,
    @SerialName(value = "scheduled_departure")
    val scheduledDeparture: Instant,
    @SerialName(value = "scheduled_platform")
    val scheduledPlatform: String?,
    @SerialName(value = "current_departure")
    val currentDeparture: Instant?,
    @SerialName(value = "current_platform")
    val currentPlatform: String?,
    @SerialName(value = "type")
    val type: String?,
)
