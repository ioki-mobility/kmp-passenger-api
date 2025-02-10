package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiEmail

public fun createApiEmail(
    emailAddress: String = "",
    newsletter: Boolean? = null,
    receipt: Boolean? = null,
    confirmed: Boolean? = null,
): ApiEmail = ApiEmail(
    emailAddress = emailAddress,
    newsletter = newsletter,
    receipt = receipt,
    confirmed = confirmed,
)
