package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiEmail
import com.ioki.passenger.api.models.ApiSignUpRequest

public fun createApiSignUpRequest(
    firstName: String = "",
    lastName: String = "",
    termsAccepted: Boolean = false,
    minimumAgeConfirmed: Boolean? = null,
    email: ApiEmail = createApiEmail(),
    version: Int = 0,
): ApiSignUpRequest = ApiSignUpRequest(
    firstName = firstName,
    lastName = lastName,
    termsAccepted = termsAccepted,
    minimumAgeConfirmed = minimumAgeConfirmed,
    email = email,
    version = version,
)
