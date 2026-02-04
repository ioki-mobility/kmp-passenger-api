package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiAuthenticatedUserResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        val userDetail = ApiEmail(
            emailAddress = "john.doe@ioki.com",
            newsletter = false,
            receipt = true,
            confirmed = true,
        )
        testJsonStringCanBeConvertedToModel(
            expectedModel = ApiAuthenticatedUserResponse(
                id = "abc123",
                firstName = "John",
                lastName = "Doe",
                registered = true,
                version = 2,
                phoneNumber = "+4912345",
                analyticsTracking = false,
                email = userDetail,
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
  "registered": true,
  "analytics_tracking":false,
  "email": {
    "email_address": "john.doe@ioki.com",
    "newsletter": false,
    "receipt": true,
    "confirmed": true
  },
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
