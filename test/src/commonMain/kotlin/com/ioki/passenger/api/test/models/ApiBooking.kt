package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiBooking

public fun createApiBooking(verificationCode: String = ""): ApiBooking = ApiBooking(verificationCode = verificationCode)
