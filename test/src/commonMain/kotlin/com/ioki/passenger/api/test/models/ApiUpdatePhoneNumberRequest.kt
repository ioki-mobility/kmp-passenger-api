package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest

public fun createApiUpdatePhoneNumberRequest(
    phoneNumber: String = "",
    code: String = "",
): ApiUpdatePhoneNumberRequest = ApiUpdatePhoneNumberRequest(
    phoneNumber = phoneNumber,
    code = code,
)
