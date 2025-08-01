package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRedeemedPromoCodeResponse
import kotlin.time.Instant

public fun createApiRedeemedPromoCodeResponse(
    id: String = "",
    createdAt: Instant = Instant.DISTANT_PAST,
    title: String = "",
    description: String = "",
    url: String? = null,
): ApiRedeemedPromoCodeResponse = ApiRedeemedPromoCodeResponse(
    id = id,
    createdAt = createdAt,
    title = title,
    description = description,
    url = url,
)
