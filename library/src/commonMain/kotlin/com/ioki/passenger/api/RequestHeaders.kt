package com.ioki.passenger.api

import com.ioki.passenger.api.internal.utils.randomUUID

public data class RequestHeaders(
    val apiVersion: String,
    val clientIdentifier: String,
    val clientVersion: String,
    val clientSecret: String,
    val languageTag: String,
    val debugIdentifier: String = randomUUID(),
)
