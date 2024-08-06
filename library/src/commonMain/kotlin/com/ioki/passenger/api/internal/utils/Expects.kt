package com.ioki.passenger.api.internal.utils

import kotlinx.datetime.LocalDateTime

internal expect fun parseRfc1123DateTime(dateTimeString: String): LocalDateTime

internal expect val Throwable.isConnectivityError: Boolean

internal expect fun randomUUID(): String
