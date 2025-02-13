package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiMoney

public fun createApiMoney(amount: Int = 0, currency: String = ""): ApiMoney =
    ApiMoney(amount = amount, currency = currency)
