package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAdditionalData

public fun createApiAdditionalData(
    marketingAutomationPushChannelEnabled: Boolean? = null,
    marketingAutomationMessageCenterChannelEnabled: Boolean? = null,
): ApiAdditionalData = ApiAdditionalData(
    marketingAutomationPushChannelEnabled = marketingAutomationPushChannelEnabled,
    marketingAutomationMessageCenterChannelEnabled = marketingAutomationMessageCenterChannelEnabled,
)
