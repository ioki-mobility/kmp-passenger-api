package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiBoundingBox(val min: ApiPoint, val max: ApiPoint)
