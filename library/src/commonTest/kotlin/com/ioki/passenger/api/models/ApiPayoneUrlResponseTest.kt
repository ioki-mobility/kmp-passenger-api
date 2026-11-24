package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPayoneUrlResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiPayoneUrlResponse(url = "https://www.saferpay.com/vt2/api/register/card/abc"),
            apiPayoneUrlResponseJson,
        )
    }
}

private val apiPayoneUrlResponseJson =
    """
    {
      "url": "https://www.saferpay.com/vt2/api/register/card/abc"
    }
    """
