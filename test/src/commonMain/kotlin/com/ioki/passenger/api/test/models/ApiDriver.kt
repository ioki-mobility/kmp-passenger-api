package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiDriver

public fun createApiDriver(connectedVehicleId: String = "", displayName: String? = null): ApiDriver = ApiDriver(
    connectedVehicleId = connectedVehicleId,
    displayName = displayName,
)
