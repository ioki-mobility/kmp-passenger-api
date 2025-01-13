package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDoorStateChangeRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiDoorStateChangeRequest(
                desiredState = ApiDoorStateChangeRequest.DesiredState.UNLOCKED,
            ),
            doorStateChangeRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiDoorStateChangeRequest(
                desiredState = ApiDoorStateChangeRequest.DesiredState.UNSUPPORTED,
            ),
            doorStateChangeRequestMinimal,
        )
    }
}

private val doorStateChangeRequest =
    """
{
  "desired_state": "unlocked"
}
"""

private val doorStateChangeRequestMinimal =
    """
{
  "desired_state": "unsupported"
}
"""
