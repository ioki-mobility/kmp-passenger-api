package com.ioki.passenger.api.models

import com.ioki.passenger.api.test.models.createApiBootstrapResponse
import com.ioki.passenger.api.test.models.createApiClientInfoResponse
import com.ioki.passenger.api.test.models.createApiProvider
import com.ioki.passenger.api.test.models.createLogPayPaymentServiceProvider
import com.ioki.passenger.api.test.models.createStripePaymentServiceProvider
import kotlin.test.Test

internal class ApiBootstrapResponseTest : IokiApiModelTest() {
    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            createApiBootstrapResponse(
                provider = createApiProvider(
                    name = "Some Company Inc.",
                    countryCode = "DE",
                    features = ApiProvider.Features.NONE,
                ),
                client = createApiClientInfoResponse(
                    distributionUrl = "url",
                    termsOfServiceUrl = "https://example.com/terms_of_service.html",
                    privacyPolicyUrl = "https://example.com/privacy_policy.html",
                    imprintUrl = "https://example.com/imprint_url.html",
                    phoneNumberRequired = false,
                    emailAddressRequired = false,
                ),
                products = emptyList(),
                ridesWithFailedPayments = emptyList(),
                renewableTicketingVouchers = emptyList(),
                productSupportUris = emptyList(),
            ),
            bootstrapMinimal,
        )
    }

    @Test
    fun serializationStripe() {
        testJsonStringCanBeConvertedToModel(
            createApiBootstrapResponse(
                provider = createApiProvider(
                    name = "Some Company Inc.",
                    countryCode = "DE",
                    features = ApiProvider.Features.NONE,
                ),
                client = createApiClientInfoResponse(
                    distributionUrl = "url",
                    termsOfServiceUrl = "https://example.com/terms_of_service.html",
                    privacyPolicyUrl = "https://example.com/privacy_policy.html",
                    imprintUrl = "https://example.com/imprint_url.html",
                    phoneNumberRequired = false,
                    emailAddressRequired = false,
                ),
                paymentServiceProvider = createStripePaymentServiceProvider(
                    stripeAccountId = "Account Id",
                    googlePaySupported = true,
                    stripeTypes = listOf(ApiStripeType.CARD),
                ),
                products = emptyList(),
                ridesWithFailedPayments = emptyList(),
                renewableTicketingVouchers = emptyList(),
                productSupportUris = emptyList(),
            ),
            bootstrapStripe,
        )
    }

    @Test
    fun serializationLogPay() {
        testJsonStringCanBeConvertedToModel(
            createApiBootstrapResponse(
                provider = createApiProvider(
                    name = "Some Company Inc.",
                    countryCode = "DE",
                    features = ApiProvider.Features.NONE,
                ),
                client = createApiClientInfoResponse(
                    distributionUrl = "url",
                    termsOfServiceUrl = "https://example.com/terms_of_service.html",
                    privacyPolicyUrl = "https://example.com/privacy_policy.html",
                    imprintUrl = "https://example.com/imprint_url.html",
                    phoneNumberRequired = false,
                    emailAddressRequired = false,
                ),
                paymentServiceProvider = createLogPayPaymentServiceProvider(
                    logPayTypes = listOf(ApiLogPayType.CARD),
                    useLegacyPaypalFlow = true,
                ),
                products = emptyList(),
                ridesWithFailedPayments = emptyList(),
                renewableTicketingVouchers = emptyList(),
                productSupportUris = emptyList(),
            ),
            bootstrapLogPay,
        )
    }
}

private val bootstrapMinimal =
    """
{
  "provider": {
    "name": "Some Company Inc.",
    "country_code": "DE",
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
    "imprint_url": "https://example.com/imprint_url.html",
    "phone_number_required": false,
    "email_address_required": false,
    "signin_verification_channels": [],
    "signup_verification_channels": []
  },
  "rides_with_failed_payments": [],
  "renewable_ticketing_vouchers": [],
  "product_support_uris": []
}
"""

private val bootstrapStripe =
    """
{
  "payment_service_provider": {
    "type": "payment_service_provider/stripe",
    "google_pay_supported": true,
    "stripe_account_id": "Account Id",
    "stripe_payment_method_types": ["card"]
  },
  "provider": {
    "name": "Some Company Inc.",
    "country_code": "DE",
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
    "imprint_url": "https://example.com/imprint_url.html",
    "phone_number_required": false,
    "email_address_required": false,
    "signin_verification_channels": [],
    "signup_verification_channels": []
  },
  "rides_with_failed_payments": [],
  "renewable_ticketing_vouchers": [],
  "product_support_uris": []
}
"""

private val bootstrapLogPay =
    """
{
  "payment_service_provider": {
    "type": "payment_service_provider/logpay",
    "logpay_payment_method_types": ["card"],
    "use_legacy_paypal_flow": true
  },
  "provider": {
    "name": "Some Company Inc.",
    "country_code": "DE",
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
    "imprint_url": "https://example.com/imprint_url.html",
    "phone_number_required": false,
    "email_address_required": false,
    "signin_verification_channels": [],
    "signup_verification_channels": []
  },
  "rides_with_failed_payments": [],
  "renewable_ticketing_vouchers": [],
  "product_support_uris": []
}
"""
