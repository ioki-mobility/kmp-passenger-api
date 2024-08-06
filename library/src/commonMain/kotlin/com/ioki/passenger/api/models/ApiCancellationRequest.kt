package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCancellationRequest(
    @SerialName(value = "ride_version") val rideVersion: Int,
    val code: String?,
    @SerialName(value = "cancellation_statement_id") val cancellationStatementId: String?,
)
