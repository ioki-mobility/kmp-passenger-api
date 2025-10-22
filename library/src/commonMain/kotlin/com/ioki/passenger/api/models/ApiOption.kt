package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiOption(val slug: String, val value: AnyValue)
