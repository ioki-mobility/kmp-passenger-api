package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCancellationVoucherRequest

public fun createApiCancellationVoucherRequest(rideVersion: Int = 0): ApiCancellationVoucherRequest =
    ApiCancellationVoucherRequest(rideVersion = rideVersion)
