package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiDriverTest : IokiApiModelTest() {
    private val noNameDriver = ApiDriver(
        connectedVehicleId = "veh_9948bf20-7984-44ce-85f1-3610daa8db3d",
        displayName = null,
    )
    private val driver = ApiDriver(
        connectedVehicleId = "veh_9948bf20-7984-44ce-85f1-3610daa8db3d",
        displayName = "John Doe",
    )

    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(driver, driverJson)
    }

    @Test
    fun serializationNoName() {
        testJsonStringCanBeConvertedToModel(noNameDriver, noNameDriverJson)
    }
}

private val driverJson =
    """
{
  "display_name": "John Doe",
  "connected_vehicle_id": "veh_9948bf20-7984-44ce-85f1-3610daa8db3d"
}
"""

private val noNameDriverJson =
    """
{
  "connected_vehicle_id": "veh_9948bf20-7984-44ce-85f1-3610daa8db3d"
}
"""
