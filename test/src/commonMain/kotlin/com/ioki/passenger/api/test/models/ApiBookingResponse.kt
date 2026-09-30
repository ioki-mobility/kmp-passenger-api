package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBookingResponse

public fun createApiBookingResponse(id: String = "", verificationCode: String = ""): ApiBookingResponse =
    ApiBookingResponse(
        id = id,
        verificationCode = verificationCode,
    )
