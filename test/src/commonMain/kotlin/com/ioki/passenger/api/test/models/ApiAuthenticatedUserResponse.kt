package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse

public fun createApiAuthenticatedUserResponse(
    id: String = "",
    firstName: String? = null,
    lastName: String? = null,
    registered: Boolean = false,
    version: Int = 0,
    phoneNumber: String = "",
    phoneNumberVerified: Boolean = false,
    emailAddress: String = "",
    emailAddressVerified: Boolean = false,
    emailAddressNewsletter: Boolean = false,
    emailAddressReceipt: Boolean = false,
    analyticsTracking: Boolean? = null,
    currentTermsAccepted: Boolean = false,
    minimumAgeConfirmed: Boolean = false,
    referringUserSet: Boolean = false,
    referralCode: String? = null,
    remainingReferrals: Int? = null,
    logpayCustomerSet: Boolean = false,
    logpaySupportDetails: ApiAuthenticatedUserResponse.LogPaySupportDetails? = null,
    uniqueCustomerId: String? = null,
): ApiAuthenticatedUserResponse = ApiAuthenticatedUserResponse(
    id = id,
    firstName = firstName,
    lastName = lastName,
    registered = registered,
    version = version,
    phoneNumber = phoneNumber,
    phoneNumberVerified = phoneNumberVerified,
    emailAddress = emailAddress,
    emailAddressVerified = emailAddressVerified,
    emailAddressNewsletter = emailAddressNewsletter,
    emailAddressReceipt = emailAddressReceipt,
    analyticsTracking = analyticsTracking,
    currentTermsAccepted = currentTermsAccepted,
    minimumAgeConfirmed = minimumAgeConfirmed,
    referringUserSet = referringUserSet,
    referralCode = referralCode,
    remainingReferrals = remainingReferrals,
    logpayCustomerSet = logpayCustomerSet,
    logpaySupportDetails = logpaySupportDetails,
    uniqueCustomerId = uniqueCustomerId,
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
