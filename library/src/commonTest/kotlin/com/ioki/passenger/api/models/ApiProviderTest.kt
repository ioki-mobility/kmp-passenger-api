package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiProvider.PaymentMethodType
import com.ioki.passenger.api.test.models.createApiProvider
import com.ioki.passenger.api.test.models.createLogPayPaymentServiceProvider
import com.ioki.passenger.api.test.models.createStripePaymentServiceProvider
import kotlin.test.Test

internal class ApiProviderTest : IokiApiModelTest() {
    @Test
    fun serializationStripePSP() {
        testJsonStringCanBeConvertedToModel(
            ApiProvider(
                name = "Ioki GmbH",
                paymentServiceProvider = createStripePaymentServiceProvider(
                    stripeAccountId = "Account Id",
                    googlePaySupported = true,
                    stripeTypes = listOf(ApiStripeType.CARD),
                ),
                countryCode = "DE",
                merchantName = "Ioki GmbH",
                ridePaymentMethodTypes = setOf(
                    PaymentMethodType.CASH,
                    PaymentMethodType.POS_PAYMENT,
                ),
                ticketingPaymentMethodTypes = setOf(
                    PaymentMethodType.CASH,
                    PaymentMethodType.POS_PAYMENT,
                ),
                serviceCreditPaymentMethodTypes = setOf(PaymentMethodType.PSP_PROVIDED),
                personalDiscountPaymentMethodTypes = setOf(PaymentMethodType.SERVICE_CREDITS),
                tipPaymentMethodTypes = setOf(PaymentMethodType.PSP_PROVIDED),
                creditOptions = ApiProvider.CreditOptions(
                    listOf(
                        ApiOfferedCreditPackage(
                            ApiMoney(amount = 100, currency = "SEK"),
                            ApiMoney(amount = 150, currency = "SEK"),
                        ),
                    ),
                ),
                features = ApiProvider.Features.NONE,
                avatar = null,
                avatarDarkmode = null,
                customUrls = listOf(
                    ApiProvider.CustomUrl(
                        name = "other",
                        url = "otherUrl",
                        sortKey = 0,
                    ),
                ),
            ),
            providerWithStripe,
        )
    }

    @Test
    fun serializationLogPayPSP() {
        testJsonStringCanBeConvertedToModel(
            ApiProvider(
                name = "Ioki GmbH",
                paymentServiceProvider = createLogPayPaymentServiceProvider(
                    logPayTypes = listOf(ApiLogPayType.PAYPAL),
                    useLegacyPaypalFlow = true,
                ),
                countryCode = "DE",
                merchantName = "Ioki GmbH",
                ridePaymentMethodTypes = setOf(
                    PaymentMethodType.CASH,
                    PaymentMethodType.POS_PAYMENT,
                ),
                ticketingPaymentMethodTypes = setOf(
                    PaymentMethodType.CASH,
                    PaymentMethodType.POS_PAYMENT,
                ),
                serviceCreditPaymentMethodTypes = setOf(PaymentMethodType.PSP_PROVIDED),
                personalDiscountPaymentMethodTypes = setOf(PaymentMethodType.SERVICE_CREDITS),
                tipPaymentMethodTypes = setOf(PaymentMethodType.PSP_PROVIDED),
                creditOptions = ApiProvider.CreditOptions(
                    listOf(
                        ApiOfferedCreditPackage(
                            ApiMoney(amount = 100, currency = "SEK"),
                            ApiMoney(amount = 150, currency = "SEK"),
                        ),
                    ),
                ),
                features = ApiProvider.Features.NONE,
                avatar = null,
                avatarDarkmode = null,
                customUrls = listOf(
                    ApiProvider.CustomUrl(
                        name = "other",
                        url = "otherUrl",
                        sortKey = 0,
                    ),
                ),
            ),
            providerWithLogPay,
        )
    }

    @Test
    fun serializationUnknownPSP() {
        testJsonStringCanBeConvertedToModel(
            createApiProvider(name = "Ioki GmbH", countryCode = "DE", features = ApiProvider.Features.NONE),
            providerUnknownPSP,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            createApiProvider(name = "Ioki GmbH", countryCode = "DE", features = ApiProvider.Features.NONE),
            providerMinimal,
        )
    }
}

private val providerWithStripe =
    """
{
  "name": "Ioki GmbH",
  "payment_service_provider": {
    "type": "payment_service_provider/stripe",
    "google_pay_supported": true,
    "stripe_account_id": "Account Id",
    "stripe_payment_method_types": ["card"]
  },
  "country_code": "DE",
  "merchant_name": "Ioki GmbH",
  "ride_payment_method_types": ["cash", "pos_payment"],
  "ticketing_payment_method_types": ["cash", "pos_payment"],
  "service_credit_payment_method_types": ["psp_provided"],
  "personal_discount_payment_method_types": ["service_credits"],
  "tip_payment_method_types": ["psp_provided"],
  "service_credit_options": {
    "packages": [
      {
        "cost": {
          "amount": 100,
          "currency": "SEK"
        },
        "value": {
          "amount": 150,
          "currency": "SEK"
        }
      }
    ]
  },
  "custom_urls": [
    {
      "name": "other",
      "url": "otherUrl",
      "sort_key": 0
    }
  ],
  "features": {
    "non_purchasable_personal_discounts": false,
    "payment": false,
    "promo_codes": false,
    "purchasable_personal_discounts": false,
    "service_credits": false,
    "analytics_tracking": false,
    "user_email_required": false,
    "marketing_automation": false,
    "newsletter": false,
    "receipts": false,
    "apply_for_non_purchasable_personal_discounts": false,
    "tickets": false
  }
}
"""

private val providerWithLogPay =
    """
{
  "name": "Ioki GmbH",
   "payment_service_provider": {
    "type": "payment_service_provider/logpay",
    "logpay_payment_method_types": ["paypal"],
    "use_legacy_paypal_flow": true
  },
  "country_code": "DE",
  "merchant_name": "Ioki GmbH",
  "ride_payment_method_types": ["cash", "pos_payment"],
  "ticketing_payment_method_types": ["cash", "pos_payment"],
  "service_credit_payment_method_types": ["psp_provided"],
  "personal_discount_payment_method_types": ["service_credits"],
  "tip_payment_method_types": ["psp_provided"],
  "service_credit_options": {
    "packages": [
      {
        "cost": {
          "amount": 100,
          "currency": "SEK"
        },
        "value": {
          "amount": 150,
          "currency": "SEK"
        }
      }
    ]
  },
  "custom_urls": [
    {
      "name": "other",
      "url": "otherUrl",
      "sort_key": 0
    }
  ],
  "features": {
    "non_purchasable_personal_discounts": false,
    "payment": false,
    "promo_codes": false,
    "purchasable_personal_discounts": false,
    "service_credits": false,
    "analytics_tracking": false,
    "user_email_required": false,
    "marketing_automation": false,
    "newsletter": false,
    "receipts": false,
    "apply_for_non_purchasable_personal_discounts": false,
    "tickets": false
  }
}
"""

private val providerMinimal =
    """
{
  "name": "Ioki GmbH",
  "country_code": "DE",
  "ride_payment_method_types": [],
  "ticketing_payment_method_types": [],
  "service_credit_payment_method_types": [],
  "personal_discount_payment_method_types": [],
  "tip_payment_method_types": [],
  "custom_urls": [],
  "features": {
    "non_purchasable_personal_discounts": false,
    "payment": false,
    "promo_codes": false,
    "purchasable_personal_discounts": false,
    "service_credits": false,
    "analytics_tracking": false,
    "user_email_required": false,
    "marketing_automation": false,
    "newsletter": false,
    "receipts": false,
    "apply_for_non_purchasable_personal_discounts": false,
    "tickets": false
  }
}
"""

private val providerUnknownPSP =
    """
{
  "name": "Ioki GmbH",
   "payment_service_provider": {
    "type": "payment_service_provider/unknown_psp"
  },
  "country_code": "DE",
  "ride_payment_method_types": [],
  "ticketing_payment_method_types": [],
  "service_credit_payment_method_types": [],
  "personal_discount_payment_method_types": [],
  "tip_payment_method_types": [],
  "custom_urls": [],
  "features": {
    "non_purchasable_personal_discounts": false,
    "payment": false,
    "promo_codes": false,
    "purchasable_personal_discounts": false,
    "service_credits": false,
    "analytics_tracking": false,
    "user_email_required": false,
    "marketing_automation": false,
    "newsletter": false,
    "receipts": false,
    "apply_for_non_purchasable_personal_discounts": false,
    "tickets": false
  }
}
"""
