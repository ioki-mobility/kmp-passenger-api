package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiCancellationVoucherResponse(
    val type: String,
    val code: String,
    @SerialName(value = "fee") val feeObject: ApiMoney,
    @SerialName(value = "valid_until") val validUntil: Instant,
    @SerialName(value = "updated_at") val updatedAt: Instant,
)
