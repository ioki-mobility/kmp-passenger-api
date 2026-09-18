package com.ioki.passenger.api.internal.utils

import io.ktor.client.engine.darwin.DarwinHttpRequestException
import kotlin.time.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.NSTimeZone
import platform.Foundation.NSURLErrorCannotConnectToHost
import platform.Foundation.NSURLErrorCannotFindHost
import platform.Foundation.NSURLErrorClientCertificateRejected
import platform.Foundation.NSURLErrorClientCertificateRequired
import platform.Foundation.NSURLErrorDNSLookupFailed
import platform.Foundation.NSURLErrorNetworkConnectionLost
import platform.Foundation.NSURLErrorNotConnectedToInternet
import platform.Foundation.NSURLErrorSecureConnectionFailed
import platform.Foundation.NSURLErrorServerCertificateHasBadDate
import platform.Foundation.NSURLErrorServerCertificateHasUnknownRoot
import platform.Foundation.NSURLErrorServerCertificateNotYetValid
import platform.Foundation.NSURLErrorServerCertificateUntrusted
import platform.Foundation.localeWithLocaleIdentifier
import platform.Foundation.timeIntervalSince1970
import platform.Foundation.timeZoneForSecondsFromGMT

private const val RFC1123_DATE_TIME_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz"

private val sslHandshakeErrorCodes = setOf(
    NSURLErrorSecureConnectionFailed,
    NSURLErrorServerCertificateHasBadDate,
    NSURLErrorServerCertificateUntrusted,
    NSURLErrorServerCertificateHasUnknownRoot,
    NSURLErrorServerCertificateNotYetValid,
    NSURLErrorClientCertificateRejected,
    NSURLErrorClientCertificateRequired,
)

private val unknownHostErrorCodes = setOf(
    NSURLErrorCannotFindHost,
    NSURLErrorDNSLookupFailed,
)

private val socketErrorCodes = setOf(
    NSURLErrorCannotConnectToHost,
    NSURLErrorNotConnectedToInternet,
)

private val closedChannelErrorCodes = setOf(
    NSURLErrorNetworkConnectionLost,
)

private val connectivityErrorCodes =
    sslHandshakeErrorCodes + unknownHostErrorCodes + socketErrorCodes + closedChannelErrorCodes

internal actual val Throwable.isPlatformConnectivityError: Boolean
    get() = this is DarwinHttpRequestException && origin.code in connectivityErrorCodes

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
