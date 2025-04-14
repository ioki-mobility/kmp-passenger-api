package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiLineItem(
    val position: Int,
    val quantity: Int,
    val description: String?,
    val title: String?,
    @SerialName(value = "amount_gross") val amountGross: ApiMoney?,
    @SerialName(value = "amount_net") val amountNet: ApiMoney?,
)
