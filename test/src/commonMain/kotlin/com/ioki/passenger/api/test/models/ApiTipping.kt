package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiTipping

public fun createApiTipping(
    minimum: ApiMoney = createApiMoney(),
    maximum: ApiMoney? = null,
    suggestions: List<ApiMoney> = emptyList(),
): ApiTipping = ApiTipping(
    minimum = minimum,
    maximum = maximum,
    suggestions = suggestions,
)
