package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiTicketingProductOption
import com.ioki.passenger.api.models.ApiTicketingShopConfigurationResponse

public fun createApiTicketingShopConfigurationResponse(
    purchaseOptions: List<ApiTicketingProductOption> = listOf(createApiTicketingProductOption()),
): ApiTicketingShopConfigurationResponse = ApiTicketingShopConfigurationResponse(
    purchaseOptions = purchaseOptions,
)
