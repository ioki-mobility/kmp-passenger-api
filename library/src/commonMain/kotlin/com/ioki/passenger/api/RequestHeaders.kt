package com.ioki.passenger.api

import kotlin.uuid.Uuid

@OptIn(kotlin.uuid.ExperimentalUuidApi::class)
public data class RequestHeaders(
    val apiVersion: String,
    val clientIdentifier: String,
    val clientVersion: String,
    val clientSecret: String,
    val languageTag: String,
    val debugIdentifier: String = Uuid.random().toString(),
)
