package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiTipResponse(val id: String, @SerialName(value = "amount") val amount: ApiMoney)
