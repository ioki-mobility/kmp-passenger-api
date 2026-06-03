package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiVerificationRequest(
    val claim: String,
    val channel: ApiVerificationChannelType,
    @SerialName(value = "us_data_transfer_accepted") val usDataTransferAccepted: Boolean?,
)
