package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiSignUpRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        val email = ApiEmail(
            emailAddress = "new.email@deutschebahn.com",
            newsletter = false,
            receipt = true,
            confirmed = null,
        )
        testSerializationWithJsonString(
            ApiSignUpRequest(
                firstName = "John",
                lastName = "Doe",
                termsAccepted = true,
                minimumAgeConfirmed = true,
                email = email,
                version = 2,
            ),
            signupRequest,
        )
    }
}

private val signupRequest =
    """
{
  "first_name": "John",
  "last_name": "Doe",
  "terms_accepted": true,
  "version": 2,
  "minimum_age_confirmed": true,
  "email": {
    "email_address": "new.email@deutschebahn.com",
    "newsletter": false,
    "receipt": true
  }
}
"""
