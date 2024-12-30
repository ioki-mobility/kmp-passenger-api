package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUnlockDoorRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiUnlockDoorRequest(
                desiredState = ApiUnlockDoorRequest.DesiredState.UNLOCKED,
            ),
            unlockDoorRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiUnlockDoorRequest(
                desiredState = ApiUnlockDoorRequest.DesiredState.UNSUPPORTED,
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
