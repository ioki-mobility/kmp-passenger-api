package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBoundingBox
import com.ioki.passenger.api.models.ApiPoint

public fun createApiBoundingBox(min: ApiPoint = createApiPoint(), max: ApiPoint = createApiPoint()): ApiBoundingBox =
    ApiBoundingBox(min = min, max = max)
