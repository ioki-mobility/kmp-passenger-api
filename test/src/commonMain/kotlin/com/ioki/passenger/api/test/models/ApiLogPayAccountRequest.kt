package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiLogPayType

public fun createApiLogPayAccountRequest(
    emailAddress: String = "",
    person: ApiLogPayAccountRequest.Person = createApiLogPayAccountRequestPerson(),
    address: ApiLogPayAccountRequest.Address = createApiLogPayAccountRequestAddress(),
    paymentMethodType: ApiLogPayType? = null,
): ApiLogPayAccountRequest = ApiLogPayAccountRequest(
    emailAddress = emailAddress,
    person = person,
    address = address,
    paymentMethodType = paymentMethodType,
)

public fun createApiLogPayAccountRequestPerson(
    gender: ApiLogPayAccountRequest.Person.Gender = ApiLogPayAccountRequest.Person.Gender.UNSUPPORTED,
    firstName: String = "",
    lastName: String = "",
    dateOfBirth: String = "",
): ApiLogPayAccountRequest.Person = ApiLogPayAccountRequest.Person(
    gender = gender,
    firstName = firstName,
    lastName = lastName,
    dateOfBirth = dateOfBirth,
)

public fun createApiLogPayAccountRequestAddress(
    recipient: String = "",
    streetWithHouseNo: String = "",
    zipCode: String = "",
    place: String = "",
    country: String = "",
): ApiLogPayAccountRequest.Address = ApiLogPayAccountRequest.Address(
    recipient = recipient,
    streetWithHouseNo = streetWithHouseNo,
    zipCode = zipCode,
    place = place,
    country = country,
)
