package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUnlockDoorRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiDoorRequest(
                desiredState = ApiDoorRequest.DesiredState.UNLOCKED,
            ),
            unlockDoorRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiDoorRequest(
                desiredState = ApiDoorRequest.DesiredState.UNSUPPORTED,
            ),
            unlockDoorRequestMinimal,
        )
    }
}

private val unlockDoorRequest =
    """
{
  "desired_state": "unlocked"
}
"""

private val unlockDoorRequestMinimal =
    """
{
  "desired_state": "unsupported"
}
"""
