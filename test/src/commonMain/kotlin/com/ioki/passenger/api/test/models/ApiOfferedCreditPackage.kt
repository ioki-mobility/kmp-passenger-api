package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney
import com.ioki.passenger.api.models.ApiOfferedCreditPackage

public fun createApiOfferedCreditPackage(
    cost: ApiMoney = createApiMoney(),
    value: ApiMoney = createApiMoney(),
): ApiOfferedCreditPackage = ApiOfferedCreditPackage(
    cost = cost,
    value = value,
)
