package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiDoorStateChangeRequest

public fun createApiDoorStateChangeRequest(
    desiredState: ApiDoorStateChangeRequest.DesiredState = ApiDoorStateChangeRequest.DesiredState.UNLOCKED,
): ApiDoorStateChangeRequest = ApiDoorStateChangeRequest(
    desiredState = desiredState,
)
