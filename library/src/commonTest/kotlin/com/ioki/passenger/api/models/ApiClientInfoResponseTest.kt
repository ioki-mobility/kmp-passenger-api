package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiClientInfoResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiClientInfoResponse(
                distributionUrl = "https://play.google.com/our-app",
                termsOfServiceUrl = "https://example.com/terms_of_service.html",
                privacyPolicyUrl = "https://example.com/privacy_policy.html",
                imprintUrl = "https://example.com/imprint_url.html",
                helpUrl = "https://example.com/help.html",
                supportEmail = "support@example.com",
                supportWebsiteUrl = "https://example.com/support_url.html",
                supportPhoneNumber = "+16465550192",
                smsPhoneNumber = "+16465550199",
            ),
            clientInfo,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiClientInfoResponse(
                distributionUrl = "https://play.google.com/our-app",
                termsOfServiceUrl = "https://example.com/terms_of_service.html",
                privacyPolicyUrl = "https://example.com/privacy_policy.html",
                imprintUrl = "https://example.com/imprint_url.html",
                helpUrl = null,
                supportEmail = null,
                supportWebsiteUrl = null,
                smsPhoneNumber = null,
                supportPhoneNumber = null,
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
    "help_url": "https://example.com/help.html",
    "support_email": "support@example.com",
    "support_website_url": "https://example.com/support_url.html",
    "support_phone_number": "+16465550192",
    "sms_support_number": "+16465550199"
}
"""

private val clientInfoMinimal =
    """
{
    "distribution_url": "https://play.google.com/our-app",
    "terms_of_service_url": "https://example.com/terms_of_service.html",
    "privacy_policy_url": "https://example.com/privacy_policy.html",
    "imprint_url": "https://example.com/imprint_url.html"
}
"""
