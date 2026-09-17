package com.ioki.passenger.api.internal.utils

import io.kotest.matchers.shouldBe
import java.net.SocketException
import java.net.UnknownHostException
import java.nio.channels.ClosedChannelException
import javax.net.ssl.SSLHandshakeException
import kotlin.test.Test

class ActualsJvmAndroidTest {

    @Test
    fun `isPlatformConnectivityError is true for SocketException`() {
        SocketException().isPlatformConnectivityError shouldBe true
    }

    @Test
    fun `isPlatformConnectivityError is true for UnknownHostException`() {
        UnknownHostException().isPlatformConnectivityError shouldBe true
    }

    @Test
    fun `isPlatformConnectivityError is true for ClosedChannelException`() {
        ClosedChannelException().isPlatformConnectivityError shouldBe true
    }

    @Test
    fun `isPlatformConnectivityError is true for SSLHandshakeException`() {
        SSLHandshakeException("handshake failed").isPlatformConnectivityError shouldBe true
    }

    @Test
    fun `isPlatformConnectivityError is false for a generic exception`() {
        Exception("generic").isPlatformConnectivityError shouldBe false
    }
}
