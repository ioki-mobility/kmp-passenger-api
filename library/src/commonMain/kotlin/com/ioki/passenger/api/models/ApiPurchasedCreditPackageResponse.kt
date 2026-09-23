package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPurchasedCreditPackageResponse(
    val id: String,
    @SerialName(value = "balance") val balance: ApiMoney,
)
