package com.ioki.passenger.api.models

import kotlin.time.Instant
import kotlin.test.Test

internal class ApiPersonalDiscountResponseTest : IokiApiModelTest() {
    @Test
    fun `personal discount serialization validity usage`() {
        testJsonStringCanBeConvertedToModel(
            stubPersonalDiscountCount,
            purchasedDiscountsUsageJson,
        )
    }

    @Test
    fun `personal discount serialization validity time`() {
        testJsonStringCanBeConvertedToModel(
            stubPersonalDiscountTime,
            purchasedDiscountsRelativeJson,
        )
    }

    @Test
    fun `personal discount serialization validity usage usage AND time`() {
        testJsonStringCanBeConvertedToModel(
            stubPersonalDiscountTimeAndCount,
            purchasedDiscountsUsageAndTimeJson,
        )
    }
}

private val stubThirdOfJulyInstant = Instant.parse("2018-07-03T13:09:28Z")
private val stubEndOfAprilInstant = Instant.parse("2019-04-30T23:59:59Z")

private val stubPersonalDiscountCount =
    ApiPersonalDiscountResponse(
        id = "456",
        title = "10er Card",
        description = "10 trips, valid forever",
        channel = ApiPersonalDiscountResponse.Channel.PURCHASED,
        validFrom = null,
        validUntil = null,
        maximumUsages = 10,
        usages = 9,
        validity = ApiPersonalDiscountResponse.Validity.USAGE,
        discountType = ApiPersonalDiscountResponse.DiscountType.ABSOLUTE,
        absoluteDiscount = null,
        fixedPricePerPassenger = null,
        relativeDiscount = null,
        fixedPricePerRide = null,
        redeemedPromoCodeId = null,
    )

private val stubPersonalDiscountTime =
    ApiPersonalDiscountResponse(
        id = "123",
        title = "April Discount card",
        description = "Valid for a limited time only",
        channel = ApiPersonalDiscountResponse.Channel.PURCHASED,
        validFrom = stubThirdOfJulyInstant,
        validUntil = stubEndOfAprilInstant,
        maximumUsages = null,
        usages = null,
        validity = ApiPersonalDiscountResponse.Validity.TIME,
        discountType = ApiPersonalDiscountResponse.DiscountType.RELATIVE,
        absoluteDiscount = null,
        fixedPricePerPassenger = null,
        relativeDiscount = null,
        fixedPricePerRide = null,
        redeemedPromoCodeId = null,
    )

private val stubPersonalDiscountTimeAndCount =
    ApiPersonalDiscountResponse(
        id = "789",
        title = "20er card April",
        description = "20 trips valid until the end of April",
        channel = ApiPersonalDiscountResponse.Channel.PURCHASED,
        validFrom = stubThirdOfJulyInstant,
        validUntil = stubEndOfAprilInstant,
        maximumUsages = 20,
        usages = 17,
        validity = ApiPersonalDiscountResponse.Validity.USAGE_AND_TIME,
        discountType = ApiPersonalDiscountResponse.DiscountType.ABSOLUTE,
        absoluteDiscount = null,
        fixedPricePerPassenger = null,
        relativeDiscount = null,
        fixedPricePerRide = null,
        redeemedPromoCodeId = null,
    )

private val purchasedDiscountsUsageJson =
    """
    {
      "id": "456",
      "created_at": "2018-07-03T13:09:32Z",
      "updated_at": "2018-07-03T13:09:32Z",
      "type": "personal_discount",
      "discount_type": "absolute",
      "usages":9,
      "maximum_usages":10,
      "discount": 90,
      "valid_from": null,
      "valid_until": null,
      "title": "10er Card",
      "description": "10 trips, valid forever",
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "channel": "purchased",
      "validity": "usage",
      "redeemed_promo_code_id": null,
      "payment_method": {
        "id": "pam_0e05f5a0-5404-4f7f-96ca-d654cdbbf09d",
        "created_at": "2018-07-02T12:51:25Z",
        "updated_at": "2018-07-02T12:51:25Z",
        "type": "payment_method",
        "payment_method_type": "stripe",
        "attached": true,
        "details": {
          "id": "src_1CjRUOF0atmGm5bMNuYDgVNi",
          "card": {
            "brand": "Visa",
            "last4": "4242",
            "country": "US",
            "funding": "credit",
            "exp_year": 2022,
            "cvc_check": "unchecked",
            "exp_month": 4,
            "fingerprint": "K4ShpsDP7vAx47WF",
            "dynamic_last4": null,
            "three_d_secure": "optional",
            "address_zip_check": "unchecked",
            "address_line1_check": null,
            "tokenization_method": null,
            "card_automatically_updated": false
          },
          "flow": "none",
          "type": "card",
          "owner": {
            "name": null,
            "email": null,
            "phone": null,
            "address": {
              "city": null,
              "line1": null,
              "line2": null,
              "state": null,
              "country": null,
              "postal_code": "12345"
            },
            "verified_name": null,
            "verified_email": null,
            "verified_phone": null,
            "verified_address": null
          },
          "usage": "reusable",
          "amount": null,
          "object": "source",
          "status": "chargeable",
          "created": 1530535844,
          "currency": null,
          "customer": "cus_D9l1l4Dw56p5Hx",
          "livemode": false,
          "metadata": {},
          "client_secret": "src_client_secret_D9l0SIti2DYtgCBRYJrxCdZB",
          "statement_descriptor": null
        }
      }
    }
    """

private val purchasedDiscountsRelativeJson =
    """
    {
      "id": "123",
      "created_at": "2018-07-03T13:09:32Z",
      "updated_at": "2018-07-03T13:09:32Z",
      "type": "personal_discount",
      "discount_type": "relative",
      "discount": 90,
      "valid_from": "2018-07-03T13:09:28Z",
      "valid_until": "2019-04-30T23:59:59Z",
      "usages":null,
      "maximum_usages":null,
      "title": "April Discount card",
      "description": "Valid for a limited time only",
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "channel": "purchased",
      "validity": "time",
      "redeemed_promo_code_id": null,
      "payment_method": {
        "id": "pam_0e05f5a0-5404-4f7f-96ca-d654cdbbf09d",
        "created_at": "2018-07-02T12:51:25Z",
        "updated_at": "2018-07-02T12:51:25Z",
        "type": "payment_method",
        "payment_method_type": "stripe",
        "attached": true,
        "details": {
          "id": "src_1CjRUOF0atmGm5bMNuYDgVNi",
          "card": {
            "brand": "Visa",
            "last4": "4242",
            "country": "US",
            "funding": "credit",
            "exp_year": 2022,
            "cvc_check": "unchecked",
            "exp_month": 4,
            "fingerprint": "K4ShpsDP7vAx47WF",
            "dynamic_last4": null,
            "three_d_secure": "optional",
            "address_zip_check": "unchecked",
            "address_line1_check": null,
            "tokenization_method": null,
            "card_automatically_updated": false
          },
          "flow": "none",
          "type": "card",
          "owner": {
            "name": null,
            "email": null,
            "phone": null,
            "address": {
              "city": null,
              "line1": null,
              "line2": null,
              "state": null,
              "country": null,
              "postal_code": "12345"
            },
            "verified_name": null,
            "verified_email": null,
            "verified_phone": null,
            "verified_address": null
          },
          "usage": "reusable",
          "amount": null,
          "object": "source",
          "status": "chargeable",
          "created": 1530535844,
          "currency": null,
          "customer": "cus_D9l1l4Dw56p5Hx",
          "livemode": false,
          "metadata": {},
          "client_secret": "src_client_secret_D9l0SIti2DYtgCBRYJrxCdZB",
          "statement_descriptor": null
        }
      }
    }
    """

private val purchasedDiscountsUsageAndTimeJson =
    """
    {
      "id": "789",
      "created_at": "2018-07-03T13:09:32Z",
      "updated_at": "2018-07-03T13:09:32Z",
      "type": "personal_discount",
      "discount_type": "absolute",
      "discount": 90,
      "valid_from": "2018-07-03T13:09:28Z",
      "valid_until": "2019-04-30T23:59:59Z",
      "usages":17,
      "maximum_usages":20,
      "title": "20er card April",
      "description": "20 trips valid until the end of April",
      "product_id": "prd_f339116f-db3e-47bd-998b-0df9a390c91f",
      "channel": "purchased",
      "validity": "usage_and_time",
      "redeemed_promo_code_id": null,
      "payment_method": {
        "id": "pam_0e05f5a0-5404-4f7f-96ca-d654cdbbf09d",
        "created_at": "2018-07-02T12:51:25Z",
        "updated_at": "2018-07-02T12:51:25Z",
        "type": "payment_method",
        "payment_method_type": "stripe",
        "attached": true,
        "details": {
          "id": "src_1CjRUOF0atmGm5bMNuYDgVNi",
          "card": {
            "brand": "Visa",
            "last4": "4242",
            "country": "US",
            "funding": "credit",
            "exp_year": 2022,
            "cvc_check": "unchecked",
            "exp_month": 4,
            "fingerprint": "K4ShpsDP7vAx47WF",
            "dynamic_last4": null,
            "three_d_secure": "optional",
            "address_zip_check": "unchecked",
            "address_line1_check": null,
            "tokenization_method": null,
            "card_automatically_updated": false
          },
          "flow": "none",
          "type": "card",
          "owner": {
            "name": null,
            "email": null,
            "phone": null,
            "address": {
              "city": null,
              "line1": null,
              "line2": null,
              "state": null,
              "country": null,
              "postal_code": "12345"
            },
            "verified_name": null,
            "verified_email": null,
            "verified_phone": null,
            "verified_address": null
          },
          "usage": "reusable",
          "amount": null,
          "object": "source",
          "status": "chargeable",
          "created": 1530535844,
          "currency": null,
          "customer": "cus_D9l1l4Dw56p5Hx",
          "livemode": false,
          "metadata": {},
          "client_secret": "src_client_secret_D9l0SIti2DYtgCBRYJrxCdZB",
          "statement_descriptor": null
        }
      }
    }
    """
