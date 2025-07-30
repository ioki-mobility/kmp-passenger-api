package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiVehicle

public fun createApiVehicle(
    licensePlate: String = "",
    nickname: String = "",
    manufacturer: String = "",
    model: String = "",
    fuelType: String = "",
    operatorInfo: String? = null,
    avatar: ApiAvatar? = null,
    autonomous: Boolean = false,
    supportsOpenDoorRequests: Boolean = false,
    doorControlAvailable: Boolean = false,
): ApiVehicle = ApiVehicle(
    licensePlate = licensePlate,
    nickname = nickname,
    manufacturer = manufacturer,
    model = model,
    fuelType = fuelType,
    operatorInfo = operatorInfo,
    avatar = avatar,
    autonomous = autonomous,
    supportsOpenDoorRequests = supportsOpenDoorRequests,
    doorControlAvailable = doorControlAvailable,
)
