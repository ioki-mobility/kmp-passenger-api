package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPoint

public fun createApiPoint(lat: Double = 0.0, lng: Double = 0.0): ApiPoint = ApiPoint(lat = lat, lng = lng)
