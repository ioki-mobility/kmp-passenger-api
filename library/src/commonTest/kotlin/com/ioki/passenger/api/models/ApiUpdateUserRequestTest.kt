package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUpdateUserRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        val email = ApiEmail(
            emailAddress = "new.email@deutschebahn.com",
            newsletter = false,
            receipt = true,
            confirmed = null,
        )
        testSerializationWithJsonString(
            ApiUpdateUserRequest(
                version = 2,
                firstName = "John",
                lastName = "Doe",
                email = email,
                termsAccepted = true,
                tracking = null,
                additionalData = ApiAdditionalData(
                    marketingAutomationPushChannelEnabled = true,
                    marketingAutomationMessageCenterChannelEnabled = false,
                ),
            ),
            updateUserRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiUpdateUserRequest(2, null, null, null, null, null, null),
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
    "email_address": "new.email@deutschebahn.com",
    "newsletter": false,
    "receipt": true
  },
  "additional_data": {
      "marketing_automation_push_channel_enabled": true,
      "marketing_automation_message_center_channel_enabled": false
  }
}
"""

private val updateUserRequestMinimal =
    """
{
  "version": 2
}
"""
