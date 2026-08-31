package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAdditionalData
import com.ioki.passenger.api.models.ApiEmail
import com.ioki.passenger.api.models.ApiUpdateUserRequest

public fun createApiUpdateUserRequest(
    version: Int = 0,
    firstName: String? = null,
    lastName: String? = null,
    email: ApiEmail? = null,
    termsAccepted: Boolean? = null,
    tracking: Boolean? = null,
    additionalData: ApiAdditionalData? = null,
    phoneNumber: String? = null,
    minimumAgeConfirmed: Boolean? = null,
): ApiUpdateUserRequest = ApiUpdateUserRequest(
    version = version,
    firstName = firstName,
    lastName = lastName,
    email = email,
    termsAccepted = termsAccepted,
    tracking = tracking,
    additionalData = additionalData,
    phoneNumber = phoneNumber,
    minimumAgeConfirmed = minimumAgeConfirmed,
)
