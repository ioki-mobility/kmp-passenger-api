package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiOption
import com.ioki.passenger.api.models.ApiPassengerSelectionRequest

public fun createApiPassengerSelectionRequest(
    type: String = "",
    options: List<ApiOption> = emptyList(),
    firstName: String? = null,
    lastName: String? = null,
): ApiPassengerSelectionRequest = ApiPassengerSelectionRequest(
    type = type,
    options = options,
    firstName = firstName,
    lastName = lastName,
)
