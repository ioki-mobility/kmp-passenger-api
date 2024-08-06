package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiEmail(
    @SerialName(value = "email_address")
    val emailAddress: String,
    val newsletter: Boolean?,
    val receipt: Boolean?,
    val confirmed: Boolean?,
)
