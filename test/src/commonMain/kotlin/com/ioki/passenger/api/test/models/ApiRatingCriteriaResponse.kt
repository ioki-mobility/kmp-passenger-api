package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRatingCriteriaResponse

public fun createApiRatingCriteriaResponse(
    type: ApiRatingCriteriaResponse.Type = ApiRatingCriteriaResponse.Type.UNSUPPORTED,
    slug: String = "",
    localizedName: String = "",
    localizedDescription: String = "",
    default: Boolean = false,
): ApiRatingCriteriaResponse = ApiRatingCriteriaResponse(
    type = type,
    slug = slug,
    localizedName = localizedName,
    localizedDescription = localizedDescription,
    default = default,
)
