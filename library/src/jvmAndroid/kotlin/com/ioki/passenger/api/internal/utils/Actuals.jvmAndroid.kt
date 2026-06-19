package com.ioki.passenger.api.internal.utils

import kotlinx.datetime.LocalDateTime
import java.net.SocketException
import java.net.UnknownHostException
import java.nio.channels.ClosedChannelException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal actual val Throwable.isPlatformConnectivityError: Boolean
    get() =
        this is SocketException ||
            this is UnknownHostException ||
            this is ClosedChannelException

internal actual fun parseRfc1123DateTime(dateTimeString: String): LocalDateTime =
    ZonedDateTime.parse(dateTimeString, DateTimeFormatter.RFC_1123_DATE_TIME).run {
        LocalDateTime(year, monthValue, dayOfMonth, hour, minute, second, nano)
    }
