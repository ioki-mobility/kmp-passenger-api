package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDoorStateChangeRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiDoorStateChangeRequest(
                desiredState = ApiDoorStateChangeRequest.DesiredState.UNLOCKED,
            ),
            doorStateChangeRequest,
        )
    }
}

private val doorStateChangeRequest =
    """
{
  "desired_state": "unlocked"
}
"""
