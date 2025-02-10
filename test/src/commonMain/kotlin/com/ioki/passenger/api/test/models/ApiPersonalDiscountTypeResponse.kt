package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiPersonalDiscountTypeResponse
import kotlinx.datetime.LocalDate

public fun createApiPersonalDiscountTypeResponse(
    id: String = "",
    title: String = "",
    description: String = "",
    price: ApiMoney = createApiMoney(),
    timeValidityMode: ApiPersonalDiscountTypeResponse.TimeValidityMode? = null,
    defaultDuration: Int? = null,
    fixedStartDate: LocalDate? = null,
    fixedEndDate: LocalDate? = null,
): ApiPersonalDiscountTypeResponse = ApiPersonalDiscountTypeResponse(
    id = id,
    title = title,
    description = description,
    price = price,
    timeValidityMode = timeValidityMode,
    defaultDuration = defaultDuration,
    fixedStartDate = fixedStartDate,
    fixedEndDate = fixedEndDate,
)
