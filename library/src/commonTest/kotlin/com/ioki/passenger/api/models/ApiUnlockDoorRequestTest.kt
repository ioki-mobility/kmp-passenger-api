package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiUnlockDoorRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiUnlockDoorRequest(
                desiredState = "unlocked"
            ),
            unlockDoorRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiUnlockDoorRequest(
                desiredState = "locked"
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
  "desired_state": "locked"
}
"""
