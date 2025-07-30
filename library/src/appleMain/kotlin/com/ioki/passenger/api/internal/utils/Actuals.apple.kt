package com.ioki.passenger.api.internal.utils

import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlin.time.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.NSTimeZone
import platform.Foundation.localeWithLocaleIdentifier
import platform.Foundation.timeIntervalSince1970
import platform.Foundation.timeZoneForSecondsFromGMT

private const val RFC1123_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz"

internal actual val Throwable.isConnectivityError: Boolean
    get() = this is SocketTimeoutException ||
        this is HttpRequestTimeoutException

internal actual fun parseRfc1123DateTime(dateTimeString: String): LocalDateTime {
    val dateFormatter = NSDateFormatter().apply {
        dateFormat = RFC1123_DATE_TIME_FORMAT
        locale = NSLocale.localeWithLocaleIdentifier("en_US_POSIX")
        timeZone = NSTimeZone.timeZoneForSecondsFromGMT(0)
    }

    val nsDate = dateFormatter.dateFromString(dateTimeString)
        ?: throw IllegalArgumentException("Invalid date string: $dateTimeString")

    val timeInterval = nsDate.timeIntervalSince1970
    val instant = Instant.fromEpochSeconds(timeInterval.toLong())

    return instant.toLocalDateTime(TimeZone.UTC)
}
