package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiProviderTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiProvider(
                name = "Ioki GmbH",
                paymentServiceProvider = ApiProvider.PaymentServiceProvider.STRIPE,
                ridePaymentMethodTypes = setOf(
                    ApiPaymentMethodType.CASH,
                    ApiPaymentMethodType.POS_PAYMENT,
                ),
                ticketingPaymentMethodTypes = setOf(
                    ApiPaymentMethodType.CASH,
                    ApiPaymentMethodType.POS_PAYMENT,
                ),
                serviceCreditPaymentMethodTypes = setOf(ApiPaymentMethodType.STRIPE),
                personalDiscountPaymentMethodTypes = setOf(ApiPaymentMethodType.SERVICE_CREDITS),
                tipPaymentMethodTypes = setOf(ApiPaymentMethodType.STRIPE),
                stripeTypes = setOf(ApiStripeType.CARD),
                logPayTypes = setOf(ApiLogPayType.SEPA_DEBIT),
                creditOptions = ApiProvider.CreditOptions(
                    listOf(
                        ApiOfferedCreditPackage(
                            ApiMoney(amount = 100, currency = "SEK"),
                            ApiMoney(amount = 150, currency = "SEK"),
                        ),
                    ),
                ),
                stripeAccountId = "AccountId",
                features = ApiProvider.Features.NONE,
                avatar = null,
                avatarDarkmode = null,
                otherUrl = "otherUrl",
            ),
            provider,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            createApiProvider(name = "Ioki GmbH", features = ApiProvider.Features.NONE),
            providerMinimal,
        )
    }

    @Test
    fun serializationStipeTypeWithWrongTypeMinimal() {
        testSerializationWithJsonString(
            createApiProvider(
                name = "Ioki GmbH",
                features = ApiProvider.Features.NONE,
                stripeTypes = setOf(
                    ApiStripeType.UNSUPPORTED,
                    ApiStripeType.CARD,
                    ApiStripeType.SEPA_DEBIT,
                ),
            ),
            providerStripeTypesWithWrongTypeMinimal,
        )
    }
}

private val provider =
    """
{
  "name": "Ioki GmbH",
  "psp": "stripe",
  "ride_payment_method_types": ["cash", "pos_payment"],
  "ticketing_payment_method_types": ["cash", "pos_payment"],
  "service_credit_payment_method_types": ["stripe"],
  "personal_discount_payment_method_types": ["service_credits"],
  "stripe_payment_method_types": ["card"],
  "logpay_payment_method_types": ["sepa_debit"],
  "tip_payment_method_types": ["stripe"],
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
  "stripe_account_id": "AccountId",
  "other_url": "otherUrl",
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
  "psp": "no_psp",
  "ride_payment_method_types": [],
  "ticketing_payment_method_types": [],
  "service_credit_payment_method_types": [],
  "personal_discount_payment_method_types": [],
  "tip_payment_method_types": [],
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

private val providerStripeTypesWithWrongTypeMinimal =
    """
{
  "name": "Ioki GmbH",
  "psp": "no_psp",
  "ride_payment_method_types": [],
  "ticketing_payment_method_types": [],
  "service_credit_payment_method_types": [],
  "personal_discount_payment_method_types": [],
  "tip_payment_method_types": [],
  "stripe_payment_method_types": ["undefined", "card", "sepa_debit"],
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
