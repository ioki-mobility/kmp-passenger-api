package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiMoney(
    val amount: Int,
    val currency: String,
)
