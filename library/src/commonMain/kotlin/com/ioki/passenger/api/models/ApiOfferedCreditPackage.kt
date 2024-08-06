package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiOfferedCreditPackage(
    @SerialName(value = "cost") val cost: ApiMoney,
    @SerialName(value = "value") val value: ApiMoney,
)
