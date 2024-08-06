package com.ioki.passenger.api.models

import kotlinx.datetime.LocalDate
import kotlin.test.Test

internal class ApiPersonalDiscountTypeResponseTest : IokiApiModelTest() {
    @Test
    fun `personal discount serialization absolute`() {
        testSerializationWithJsonString(
            stubPersonalDiscountTypeCount,
            purchaseablePersonalDiscountTypeAbsoluteJson,
        )
    }

    @Test
    fun `personal discount serialization relative`() {
        testSerializationWithJsonString(
            stubPersonalDiscountTypeTime,
            purchaseablePersonalDiscountTypeRelativeJson,
        )
    }

    @Test
    fun `personal discount serialization absolute AND relative`() {
        testSerializationWithJsonString(
            stubPersonalDiscountTypeTimeAndCount,
            purchaseablePersonalDiscountTypeAbsoluteRelativeJson,
        )
    }

    @Test
    fun `personal discount type serialization with LocalDate`() {
        testSerializationWithJsonString(
            stubPersonalDiscountTypeLocalDate,
            purchaseablePersonalDiscountTypeLocalDateJson,
        )
    }
}

private val stubPersonalDiscountTypeTime =
    ApiPersonalDiscountTypeResponse(
        id = "123",
        title = "April Discount card",
        description = "Valid for a limited time only",
        price = ApiMoney(100, "EUR"),
        timeValidityMode = null,
        defaultDuration = 5259492,
        fixedStartDate = null,
        fixedEndDate = null,
    )

private val stubPersonalDiscountTypeCount =
    ApiPersonalDiscountTypeResponse(
        id = "456",
        title = "10er Card",
        description = "10 trips, valid forever",
        price = ApiMoney(100, "EUR"),
        timeValidityMode = null,
        defaultDuration = null,
        fixedStartDate = null,
        fixedEndDate = null,
    )

private val stubPersonalDiscountTypeTimeAndCount =
    ApiPersonalDiscountTypeResponse(
        id = "789",
        title = "20er card April",
        description = "20 trips valid until the end of April",
        price = ApiMoney(100, "EUR"),
        timeValidityMode = null,
        defaultDuration = 5259492,
        fixedStartDate = null,
        fixedEndDate = null,
    )

private val stubPersonalDiscountTypeLocalDate =
    ApiPersonalDiscountTypeResponse(
        id = "789",
        title = "20er card April",
        description = "20 trips valid until the end of April",
        price = ApiMoney(100, "EUR"),
        timeValidityMode = ApiPersonalDiscountTypeResponse.TimeValidityMode.FIXED_START_AND_END,
        defaultDuration = null,
        fixedStartDate = LocalDate(year = 2022, monthNumber = 5, dayOfMonth = 12),
        fixedEndDate = LocalDate(year = 2023, monthNumber = 7, dayOfMonth = 11),
    )

private val purchaseablePersonalDiscountTypeAbsoluteJson =
    """
   {
      "id": "456",
      "created_at": "2018-06-27T13:18:29Z",
      "updated_at": "2018-06-27T13:18:29Z",
      "type": "personal_discount_type",
      "title": "10er Card",
      "description": "10 trips, valid forever",
      "discount": 90,
      "default_duration": null,
      "maximum_usages": 10,
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "purchasable": true,
      "price": {
        "amount": 100,
        "currency": "EUR"
      }
    }
    """

private val purchaseablePersonalDiscountTypeRelativeJson =
    """
   {
      "id": "123",
      "created_at": "2018-06-27T13:18:29Z",
      "updated_at": "2018-06-27T13:18:29Z",
      "type": "personal_discount_type",
      "title": "April Discount card",
      "description": "Valid for a limited time only",
      "discount": 90,
      "default_duration": 5259492,
      "maximum_usages": null,
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "purchasable": true,
      "price": {
        "amount": 100,
        "currency": "EUR"
      }
    }
    """

private val purchaseablePersonalDiscountTypeAbsoluteRelativeJson =
    """
   {
      "id": "789",
      "created_at": "2018-06-27T13:18:29Z",
      "updated_at": "2018-06-27T13:18:29Z",
      "type": "personal_discount_type",
      "title": "20er card April",
      "description": "20 trips valid until the end of April",
      "discount": 90,
      "default_duration": 5259492,
      "maximum_usages": 20,
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "purchasable": true,
      "price": {
        "amount": 100,
        "currency": "EUR"
      }
    }
    """

private val purchaseablePersonalDiscountTypeLocalDateJson =
    """
   {
      "id": "789",
      "created_at": "2018-06-27T13:18:29Z",
      "updated_at": "2018-06-27T13:18:29Z",
      "type": "personal_discount_type",
      "title": "20er card April",
      "description": "20 trips valid until the end of April",
      "discount": 90,
      "maximum_usages": 20,
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "purchasable": true,
      "price": {
        "amount": 100,
        "currency": "EUR"
      },
      "time_validity_mode": "fixed_start_and_end",
      "fixed_start_date": "2022-05-12",
      "fixed_end_date": "2023-07-11"
    }
    """
