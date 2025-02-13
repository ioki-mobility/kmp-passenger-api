package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiTicketingProductOption

public fun createApiTicketingProductOption(
    slug: String = "",
    name: String = "",
    description: String = "",
    dataType: ApiTicketingProductOption.DataType = ApiTicketingProductOption.DataType.UNSUPPORTED,
    dataFormat: ApiTicketingProductOption.DataFormat = ApiTicketingProductOption.DataFormat.UNSUPPORTED,
    dataEnum: Boolean = false,
    enumItems: List<ApiTicketingProductOption.EnumItem> = emptyList(),
    required: Boolean = false,
): ApiTicketingProductOption = ApiTicketingProductOption(
    slug = slug,
    name = name,
    description = description,
    dataType = dataType,
    dataFormat = dataFormat,
    dataEnum = dataEnum,
    enumItems = enumItems,
    required = required,
)

public fun createApiTicketingProductOptionEnumItem(
    slug: String = "",
    name: String = "",
    description: String = "",
    value: String = "",
): ApiTicketingProductOption.EnumItem = ApiTicketingProductOption.EnumItem(
    slug = slug,
    name = name,
    description = description,
    value = value,
)
