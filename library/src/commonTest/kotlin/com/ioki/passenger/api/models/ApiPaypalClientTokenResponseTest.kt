package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPaypalClientTokenResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPaypalClientTokenResponse("token"),
            paypalClientToken,
        )
    }
}

private val paypalClientToken =
    """
{
  "client_token": "token"
}
"""
