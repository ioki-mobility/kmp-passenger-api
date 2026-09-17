package com.ioki.passenger.api.internal.utils

import io.kotest.matchers.shouldBe
import io.ktor.client.engine.darwin.DarwinHttpRequestException
import platform.Foundation.NSError
import platform.Foundation.NSURLErrorCannotConnectToHost
import platform.Foundation.NSURLErrorCannotFindHost
import platform.Foundation.NSURLErrorClientCertificateRejected
import platform.Foundation.NSURLErrorClientCertificateRequired
import platform.Foundation.NSURLErrorDNSLookupFailed
import platform.Foundation.NSURLErrorDomain
import platform.Foundation.NSURLErrorNetworkConnectionLost
import platform.Foundation.NSURLErrorNotConnectedToInternet
import platform.Foundation.NSURLErrorSecureConnectionFailed
import platform.Foundation.NSURLErrorServerCertificateHasBadDate
import platform.Foundation.NSURLErrorServerCertificateHasUnknownRoot
import platform.Foundation.NSURLErrorServerCertificateNotYetValid
import platform.Foundation.NSURLErrorServerCertificateUntrusted
import platform.Foundation.NSURLErrorUnknown
import kotlin.test.Test

class ActualsAppleTest {

    @Test
    fun `isPlatformConnectivityError is true for SSL handshake related NSError codes`() {
        listOf(
            NSURLErrorSecureConnectionFailed,
            NSURLErrorServerCertificateHasBadDate,
            NSURLErrorServerCertificateUntrusted,
            NSURLErrorServerCertificateHasUnknownRoot,
            NSURLErrorServerCertificateNotYetValid,
            NSURLErrorClientCertificateRejected,
            NSURLErrorClientCertificateRequired,
        ).forEach { code ->
            darwinException(code).isPlatformConnectivityError shouldBe true
        }
    }

    @Test
    fun `isPlatformConnectivityError is true for unknown host related NSError codes`() {
        listOf(
            NSURLErrorCannotFindHost,
            NSURLErrorDNSLookupFailed,
        ).forEach { code ->
            darwinException(code).isPlatformConnectivityError shouldBe true
        }
    }

    @Test
    fun `isPlatformConnectivityError is true for socket related NSError codes`() {
        listOf(
            NSURLErrorCannotConnectToHost,
            NSURLErrorNotConnectedToInternet,
        ).forEach { code ->
            darwinException(code).isPlatformConnectivityError shouldBe true
        }
    }

    @Test
    fun `isPlatformConnectivityError is true for closed channel related NSError codes`() {
        darwinException(NSURLErrorNetworkConnectionLost).isPlatformConnectivityError shouldBe true
    }

    @Test
    fun `isPlatformConnectivityError is false for an unrelated NSError code`() {
        darwinException(NSURLErrorUnknown).isPlatformConnectivityError shouldBe false
    }

    @Test
    fun `isPlatformConnectivityError is false for a generic exception`() {
        Exception("generic").isPlatformConnectivityError shouldBe false
    }

    private fun darwinException(code: Long) =
        DarwinHttpRequestException(NSError(NSURLErrorDomain, code, userInfo = null))
}
