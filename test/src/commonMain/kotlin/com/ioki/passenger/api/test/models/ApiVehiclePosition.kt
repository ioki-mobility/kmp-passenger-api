package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiVehiclePosition

public fun createApiVehiclePosition(lat: Double = 0.0, lng: Double = 0.0, heading: Float? = null): ApiVehiclePosition =
    ApiVehiclePosition(lat = lat, lng = lng, heading = heading)
