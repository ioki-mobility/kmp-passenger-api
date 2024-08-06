package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPhoneVerificationRequest(
    @SerialName(value = "phone_number") val phoneNumber: String,
    @SerialName(value = "us_data_transfer_accepted") val usDataTransferAccepted: Boolean?,
)
