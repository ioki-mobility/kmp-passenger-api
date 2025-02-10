package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiRideSeriesRequest
import kotlinx.datetime.LocalDate

public fun createApiRideSeriesRequest(additionalDates: List<LocalDate> = emptyList()): ApiRideSeriesRequest =
    ApiRideSeriesRequest(additionalDates = additionalDates)
