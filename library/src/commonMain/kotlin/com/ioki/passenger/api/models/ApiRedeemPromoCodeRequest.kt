package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiRedeemPromoCodeRequest(val code: String)
