package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiRedeemReferralCodeRequest(
    @SerialName(value = "referral_code") val code: String,
)
