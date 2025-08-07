package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiGeocodingSessionResponse
import kotlin.time.Instant

public fun createApiGeocodingSessionResponse(
    id: String = "",
    createdAt: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant? = null,
    validUntil: Instant = Instant.DISTANT_PAST,
): ApiGeocodingSessionResponse = ApiGeocodingSessionResponse(
    id = id,
    createdAt = createdAt,
    updatedAt = updatedAt,
    validUntil = validUntil,
)
