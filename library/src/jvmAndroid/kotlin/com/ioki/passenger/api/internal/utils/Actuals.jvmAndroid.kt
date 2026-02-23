package com.ioki.passenger.api.internal.utils

import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.datetime.LocalDateTime
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException
import java.nio.channels.ClosedChannelException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal actual val Throwable.isConnectivityError: Boolean
    get() =
        this is SocketException ||
            this is SocketTimeoutException ||
            this is HttpRequestTimeoutException ||
            this is UnknownHostException ||
            this is ClosedChannelException ||
            this is ConnectException

internal actual fun parseRfc1123DateTime(dateTimeString: String): LocalDateTime =
    ZonedDateTime.parse(dateTimeString, DateTimeFormatter.RFC_1123_DATE_TIME).run {
        LocalDateTime(year, monthValue, dayOfMonth, hour, minute, second, nano)
    }
