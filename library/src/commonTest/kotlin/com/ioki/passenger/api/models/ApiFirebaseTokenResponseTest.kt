package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiFirebaseTokenResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiFirebaseTokenResponse("jwt", "encryptionKey"),
            firebaseToken,
        )
    }
}

private val firebaseToken =
    """
{
  "jwt": "jwt",
  "encryption_key": "encryptionKey"
}
"""
