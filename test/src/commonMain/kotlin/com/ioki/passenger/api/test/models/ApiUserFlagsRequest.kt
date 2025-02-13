package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiUserFlagsRequest

public fun createApiUserFlagsRequest(
    version: Int = 0,
    termsAccepted: Boolean? = null,
    minimumAgeConfirmed: Boolean? = null,
    analyticsTracking: Boolean? = null,
): ApiUserFlagsRequest = ApiUserFlagsRequest(
    version = version,
    termsAccepted = termsAccepted,
    minimumAgeConfirmed = minimumAgeConfirmed,
    analyticsTracking = analyticsTracking,
)
