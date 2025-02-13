package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAdditionalData
import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse
import com.ioki.passenger.api.models.ApiEmail

public fun createApiAuthenticatedUserResponse(
    id: String = "",
    firstName: String? = null,
    lastName: String? = null,
    registered: Boolean = false,
    version: Int = 0,
    phoneNumber: String = "",
    analyticsTracking: Boolean? = null,
    email: ApiEmail? = null,
    currentTermsAccepted: Boolean = false,
    minimumAgeConfirmed: Boolean = false,
    referringUserSet: Boolean = false,
    referralCode: String? = null,
    remainingReferrals: Int? = null,
    allowMarketing: Boolean? = null,
    airshipNamedUserId: String? = null,
    logpayCustomerSet: Boolean = false,
    logpaySupportDetails: ApiAuthenticatedUserResponse.LogPaySupportDetails? = null,
    uniqueCustomerId: String? = null,
    additionalData: ApiAdditionalData? = null,
): ApiAuthenticatedUserResponse = ApiAuthenticatedUserResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    registered = registered,
    version = version,
    phoneNumber = phoneNumber,
    analyticsTracking = analyticsTracking,
    email = email,
    currentTermsAccepted = currentTermsAccepted,
    minimumAgeConfirmed = minimumAgeConfirmed,
    referringUserSet = referringUserSet,
    referralCode = referralCode,
    remainingReferrals = remainingReferrals,
    allowMarketing = allowMarketing,
    airshipNamedUserId = airshipNamedUserId,
    logpayCustomerSet = logpayCustomerSet,
    logpaySupportDetails = logpaySupportDetails,
    uniqueCustomerId = uniqueCustomerId,
    additionalData = additionalData,
)

public fun createApiAuthenticatedUserResponseLogPaySupportDetails(
    email: String = "",
    subject: String = "",
    body: String = "",
): ApiAuthenticatedUserResponse.LogPaySupportDetails = ApiAuthenticatedUserResponse.LogPaySupportDetails(
    email = email,
    subject = subject,
    body = body,
)
