package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiLogPayAccountRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiLogPayAccountRequest(
                emailAddress = "john.doe@gmail.com",
                person = ApiLogPayAccountRequest.Person(
                    firstName = "John",
                    lastName = "Doe",
                    dateOfBirth = "1990-01-01",
                ),
                address = ApiLogPayAccountRequest.Address(
                    recipient = "John Doe",
                    streetWithHouseNo = "Main Street 1",
                    zipCode = "12345",
                    place = "Springfield",
                    country = "USA",
                ),
                paymentMethodType = ApiLogPayType.CARD,
            ),
            apiLogPayAccountRequestJson,
        )
    }

    @Test
    fun serializationPaymentMethodTypeUndefined() {
        testJsonStringCanBeConvertedToModel(
            ApiLogPayAccountRequest(
                emailAddress = "john.doe@gmail.com",
                person = ApiLogPayAccountRequest.Person(
                    firstName = "John",
                    lastName = "Doe",
                    dateOfBirth = "1990-01-01",
                ),
                address = ApiLogPayAccountRequest.Address(
                    recipient = "John Doe",
                    streetWithHouseNo = "Main Street 1",
                    zipCode = "12345",
                    place = "Springfield",
                    country = "USA",
                ),
                paymentMethodType = ApiLogPayType.UNSUPPORTED,
            ),
            apiLogPayAccountRequestPaymentMethodTypeUndefinedJson,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiLogPayAccountRequest(
                emailAddress = "john.doe@gmail.com",
                person = ApiLogPayAccountRequest.Person(
                    firstName = "John",
                    lastName = "Doe",
                    dateOfBirth = "1990-01-01",
                ),
                address = ApiLogPayAccountRequest.Address(
                    recipient = "John Doe",
                    streetWithHouseNo = "Main Street 1",
                    zipCode = "12345",
                    place = "Springfield",
                    country = "USA",
                ),
                paymentMethodType = null,
            ),
            apiLogPayAccountRequestMinimalJson,
        )
    }
}

private val apiLogPayAccountRequestJson =
    """
   {
      "email": "john.doe@gmail.com",
      "person": {
        "forename": "John",
        "surname": "Doe",
        "birth": "1990-01-01"
      },
      "address_residence": {
        "to1": "John Doe",
        "street": "Main Street 1",
        "post_code": "12345",
        "place": "Springfield",
        "country": "USA"
      },
      "payment_method_type": "card"
    }
    """

private val apiLogPayAccountRequestPaymentMethodTypeUndefinedJson =
    """
   {
      "email": "john.doe@gmail.com",
      "person": {
        "forename": "John",
        "surname": "Doe",
        "birth": "1990-01-01"
      },
      "address_residence": {
        "to1": "John Doe",
        "street": "Main Street 1",
        "post_code": "12345",
        "place": "Springfield",
        "country": "USA"
      },
      "payment_method_type": "UNDEFINED"
    }
    """

private val apiLogPayAccountRequestMinimalJson =
    """
   {
      "email": "john.doe@gmail.com",
      "person": {
        "forename": "John",
        "surname": "Doe",
        "birth": "1990-01-01"
      },
      "address_residence": {
        "to1": "John Doe",
        "street": "Main Street 1",
        "post_code": "12345",
        "place": "Springfield",
        "country": "USA"
      },
      "payment_method_type": null
    }
    """
