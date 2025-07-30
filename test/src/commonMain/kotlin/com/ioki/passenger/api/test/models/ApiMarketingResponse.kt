package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse
import com.ioki.passenger.api.models.ApiMarketingResponse
import kotlin.time.Instant

public fun createApiMarketingResponse(
    id: String = "",
    createdAt: Instant = Instant.DISTANT_PAST,
    updatedAt: Instant = Instant.DISTANT_PAST,
    type: String = "",
    user: ApiAuthenticatedUserResponse = createApiAuthenticatedUserResponse(),
): ApiMarketingResponse = ApiMarketingResponse(
    id = id,
    createdAt = createdAt,
    updatedAt = updatedAt,
    type = type,
    user = user,
)
