package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPurchasedCreditPackageResponse(
    @SerialName(value = "balance") val balance: ApiMoney,
)
