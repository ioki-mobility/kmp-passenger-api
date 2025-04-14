package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiLineItem
import com.ioki.passenger.api.models.ApiMoney

public fun createApiLineItem(
    position: Int = 0,
    quantity: Int = 0,
    description: String? = null,
    title: String? = null,
    amountGross: ApiMoney? = null,
    amountNet: ApiMoney? = null,
): ApiLineItem = ApiLineItem(
    position = position,
    quantity = quantity,
    description = description,
    title = title,
    amountGross = amountGross,
    amountNet = amountNet,
)
