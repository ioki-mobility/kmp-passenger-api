package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUpdateUserRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        val email = ApiEmail(
            emailAddress = "new.email@ioki.com",
            newsletter = false,
            receipt = true,
            confirmed = null,
        )
        testJsonStringCanBeConvertedToModel(
            ApiUpdateUserRequest(
                version = 2,
                firstName = "John",
                lastName = "Doe",
                email = email,
                termsAccepted = true,
                tracking = null,
                phoneNumber = "+491234567",
                minimumAgeConfirmed = true,
            ),
            updateUserRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiUpdateUserRequest(
                version = 2,
                firstName = null,
                lastName = null,
                email = null,
                termsAccepted = null,
                tracking = null,
                phoneNumber = null,
                minimumAgeConfirmed = null,
            ),
            updateUserRequestMinimal,
        )
    }
}

private val updateUserRequest =
    """
{
  "first_name": "John",
  "last_name": "Doe",
  "terms_accepted": true,
  "version": 2,
  "email": {
    "email_address": "new.email@ioki.com",
    "newsletter": false,
    "receipt": true
  },
  "phone_number": "+491234567",
  "minimum_age_confirmed": true
}
"""

private val updateUserRequestMinimal =
    """
{
  "version": 2
}
"""
