package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiTicketingShopConfigurationResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiTicketingShopConfigurationResponse(
                purchaseOptions = listOf(
                    ApiTicketingProductOption(
                        slug = "1",
                        name = "Ticket 1",
                        description = "Description 1",
                        dataType = ApiTicketingProductOption.DataType.NUMBER,
                        dataFormat = ApiTicketingProductOption.DataFormat.EMPTY,
                        dataEnum = false,
                        enumItems = emptyList(),
                        required = true,
                    ),
                    ApiTicketingProductOption(
                        slug = "2",
                        name = "Ticket 2",
                        description = "Description 2",
                        dataType = ApiTicketingProductOption.DataType.STRING,
                        dataFormat = ApiTicketingProductOption.DataFormat.DATE,
                        dataEnum = false,
                        enumItems = emptyList(),
                        required = false,
                    ),
                ),
            ),
            ticketingShopConfigurationResponse,
        )
    }
}

private val ticketingShopConfigurationResponse =
    """
{
    "purchase_options": [
        {
            "slug": "1",
            "name": "Ticket 1",
            "description": "Description 1",
            "data_type": "number",
            "data_format": "",
            "data_enum": false,
            "enum_items": [],
            "required": true
        },
        {
            "slug": "2",
            "name": "Ticket 2",
            "description": "Description 2",
            "data_type": "string",
            "data_format": "date",
            "data_enum": false,
            "enum_items": [],
            "required": false
        }
    ]
}
"""
