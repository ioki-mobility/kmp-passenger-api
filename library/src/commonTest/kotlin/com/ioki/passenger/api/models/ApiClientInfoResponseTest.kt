package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiClientInfoResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiClientInfoResponse(
                distributionUrl = "https://play.google.com/our-app",
                termsOfServiceUrl = "https://example.com/terms_of_service.html",
                privacyPolicyUrl = "https://example.com/privacy_policy.html",
                imprintUrl = "https://example.com/imprint_url.html",
                phoneNumberRequired = true,
                emailAddressRequired = false,
                helpUrl = "https://example.com/help.html",
                supportEmail = "support@example.com",
                supportWebsiteUrl = "https://example.com/support_url.html",
                supportPhoneNumber = "+16465550192",
                smsPhoneNumber = "+16465550199",
                preferredVerificationChannel = ApiVerificationChannelType.EMAIL,
                signInVerificationChannels = listOf(ApiVerificationChannelType.SMS),
                signUpVerificationChannels = listOf(
                    ApiVerificationChannelType.SMS,
                    ApiVerificationChannelType.EMAIL,
                ),
            ),
            clientInfo,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiClientInfoResponse(
                distributionUrl = "https://play.google.com/our-app",
                termsOfServiceUrl = "https://example.com/terms_of_service.html",
                privacyPolicyUrl = "https://example.com/privacy_policy.html",
                imprintUrl = "https://example.com/imprint_url.html",
                phoneNumberRequired = false,
                emailAddressRequired = false,
                helpUrl = null,
                supportEmail = null,
                supportWebsiteUrl = null,
                smsPhoneNumber = null,
                supportPhoneNumber = null,
                preferredVerificationChannel = null,
                signInVerificationChannels = emptyList(),
                signUpVerificationChannels = emptyList(),
            ),
            clientInfoMinimal,
        )
    }
}

private val clientInfo =
    """
{
    "distribution_url": "https://play.google.com/our-app",
    "terms_of_service_url": "https://example.com/terms_of_service.html",
    "privacy_policy_url": "https://example.com/privacy_policy.html",
    "imprint_url": "https://example.com/imprint_url.html",
    "phone_number_required": true,
    "email_address_required": false,
    "help_url": "https://example.com/help.html",
    "support_email": "support@example.com",
    "support_website_url": "https://example.com/support_url.html",
    "support_phone_number": "+16465550192",
    "sms_support_number": "+16465550199",
    "preferred_verification_channel": "email",
    "signin_verification_channels": ["sms"],
    "signup_verification_channels": ["sms", "email"]
}
"""

private val clientInfoMinimal =
    """
{
    "distribution_url": "https://play.google.com/our-app",
    "terms_of_service_url": "https://example.com/terms_of_service.html",
    "privacy_policy_url": "https://example.com/privacy_policy.html",
    "imprint_url": "https://example.com/imprint_url.html",
    "phone_number_required": false,
    "email_address_required": false,
    "signin_verification_channels": [],
    "signup_verification_channels": []
}
"""
