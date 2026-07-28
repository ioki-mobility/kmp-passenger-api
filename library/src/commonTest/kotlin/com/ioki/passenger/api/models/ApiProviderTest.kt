package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiProvider.PaymentMethodType
import com.ioki.passenger.api.test.models.createApiProvider
import kotlin.test.Test

internal class ApiProviderTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiProvider(
                name = "Ioki GmbH",
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
            provider,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            createApiProvider(name = "Ioki GmbH", countryCode = "DE", features = ApiProvider.Features.NONE),
            providerMinimal,
        )
    }

    @Test
    fun serializationStipeTypeWithWrongTypeMinimal() {
        testJsonStringCanBeConvertedToModel(
            createApiProvider(
                name = "Ioki GmbH",
                countryCode = "DE",
                features = ApiProvider.Features.NONE,
            ),
            providerStripeTypesWithWrongTypeMinimal,
        )
    }
}

private val provider =
    """
{
  "name": "Ioki GmbH",
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

private val providerStripeTypesWithWrongTypeMinimal =
    """
{
  "name": "Ioki GmbH",
  "country_code": "DE",
  "ride_payment_method_types": [],
  "ticketing_payment_method_types": [],
  "service_credit_payment_method_types": [],
  "personal_discount_payment_method_types": [],
  "tip_payment_method_types": [],
  "stripe_payment_method_types": ["undefined", "card", "sepa_debit"],
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
