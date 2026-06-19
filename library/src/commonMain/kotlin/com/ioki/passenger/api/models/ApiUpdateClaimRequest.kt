package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiUpdateClaimRequest(
    val claim: String,
    @SerialName(value = "claim_type") val claimType: ClaimType,
    val code: String,
) {
    @Serializable
    public enum class ClaimType {
        @SerialName(value = "email_address")
        EMAIL_ADDRESS,

        @SerialName(value = "phone_number")
        PHONE_NUMBER,
    }
}
