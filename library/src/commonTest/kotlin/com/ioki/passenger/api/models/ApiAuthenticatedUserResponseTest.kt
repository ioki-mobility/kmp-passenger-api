package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiAuthenticatedUserResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiAuthenticatedUserResponse(
                id = "abc123",
                firstName = "John",
                lastName = "Doe",
                registered = true,
                version = 2,
                phoneNumber = "+4912345",
                phoneNumberVerified = true,
                emailAddress = "john.doe@ioki.com",
                emailAddressVerified = true,
                emailAddressNewsletter = false,
                emailAddressReceipt = true,
                analyticsTracking = false,
                currentTermsAccepted = true,
                minimumAgeConfirmed = true,
                referringUserSet = true,
                referralCode = "IAMYOURFRIEND",
                remainingReferrals = 5,
                logpayCustomerSet = false,
                logpaySupportDetails = ApiAuthenticatedUserResponse.LogPaySupportDetails(
                    email = "test.ioki@logpay.com",
                    subject = "Declined payment",
                    body = "Your account is suspended",
                ),
                uniqueCustomerId = "IOKI42",
            ),
            jsonString = authenticatedUser,
        )
    }
}

private val authenticatedUser = """
{
  "id": "abc123",
  "first_name": "John",
  "last_name": "Doe",
  "phone_number": "+4912345",
  "phone_number_verified": true,
  "registered": true,
  "email_address": "john.doe@ioki.com",
  "email_address_verified": true,
  "email_address_newsletter": false,
  "email_address_receipt": true,
  "analytics_tracking":false,
  "current_terms_accepted": true,
  "minimum_age_confirmed": true,
  "referring_user_set": true,
  "referral_code": "IAMYOURFRIEND",
  "remaining_referrals": 5,
  "version": 2,
  "logpay_customer_set": false,
  "logpay_support_details": {
    "email": "test.ioki@logpay.com",
    "subject": "Declined payment",
    "body": "Your account is suspended"
  },
  "unique_customer_id": "IOKI42"
}
"""
