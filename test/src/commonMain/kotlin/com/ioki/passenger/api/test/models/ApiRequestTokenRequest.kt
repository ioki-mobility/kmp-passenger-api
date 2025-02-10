package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRequestTokenRequest

public fun createApiRequestTokenRequest(phoneNumber: String = "", code: String = ""): ApiRequestTokenRequest =
    ApiRequestTokenRequest(phoneNumber = phoneNumber, code = code)
