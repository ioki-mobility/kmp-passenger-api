package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiPublicTransportType
import com.ioki.passenger.api.models.ApiScheduleResponse
import kotlinx.datetime.Instant

public fun createApiScheduleResponse(
    transportType: ApiPublicTransportType = ApiPublicTransportType.UNSUPPORTED,
    direction: String = "",
    name: String = "",
    scheduledDeparture: Instant = Instant.DISTANT_PAST,
    scheduledPlatform: String? = null,
    currentDeparture: Instant? = null,
    currentPlatform: String? = null,
    type: String? = null,
): ApiScheduleResponse = ApiScheduleResponse(
    transportType = transportType,
    direction = direction,
    name = name,
    scheduledDeparture = scheduledDeparture,
    scheduledPlatform = scheduledPlatform,
    currentDeparture = currentDeparture,
    currentPlatform = currentPlatform,
    type = type,
)
