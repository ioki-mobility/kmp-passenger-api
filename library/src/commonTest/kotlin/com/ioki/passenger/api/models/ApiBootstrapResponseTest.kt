package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiClientInfoResponse
import com.ioki.passenger.api.test.models.createApiProvider
import kotlin.test.Test

internal class ApiBootstrapResponseTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiBootstrapResponse(
                provider = createApiProvider(
                    name = "Some Company Inc.",
                    paymentServiceProvider = ApiProvider.PaymentServiceProvider.NONE,
                    features = ApiProvider.Features.NONE,
                ),
                client = createApiClientInfoResponse(
                    distributionUrl = "url",
                    termsOfServiceUrl = "https://example.com/terms_of_service.html",
                    privacyPolicyUrl = "https://example.com/privacy_policy.html",
                    imprintUrl = "https://example.com/imprint_url.html",
                ),
                products = emptyList(),
                ridesWithFailedPayments = emptyList(),
                renewableTicketingVouchers = emptyList(),
                productSupportUris = emptyList(),
            ),
            bootstrap,
        )
    }
}

private val bootstrap =
    """
{
  "provider": {
    "name": "Some Company Inc.",
    "psp": "no_psp",
    "ride_payment_method_types": [],
    "ticketing_payment_method_types": [],
    "service_credit_payment_method_types": [],
    "personal_discount_payment_method_types": [],
    "tip_payment_method_types": [],
    "custom_urls": [],
    "features": {
      "non_purchasable_personal_discounts" : false,
      "payment":false,
      "promo_codes" : false,
      "purchasable_personal_discounts" : false,
      "service_credits" : false,
      "analytics_tracking" : false,
      "user_email_required" : false,
      "marketing_automation": false,
      "newsletter": false,
      "receipts": false,
      "apply_for_non_purchasable_personal_discounts": false,
      "tickets": false
    }
  },
  "products": [],
  "client": {
    "distribution_url": "url",
    "terms_of_service_url": "https://example.com/terms_of_service.html",
    "privacy_policy_url": "https://example.com/privacy_policy.html",
    "imprint_url": "https://example.com/imprint_url.html"
  },
  "rides_with_failed_payments": [],
  "renewable_ticketing_vouchers": [],
  "product_support_uris": []
}
"""
