package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiStripeSetupIntentResponse(@SerialName(value = "client_secret") val clientSecret: String)
