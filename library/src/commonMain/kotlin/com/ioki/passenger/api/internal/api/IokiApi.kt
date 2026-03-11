package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.internal.IokiHttpClient
import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiBookingRequest
import com.ioki.passenger.api.models.ApiCalculateNewFareRequest
import com.ioki.passenger.api.models.ApiCancellationRequest
import com.ioki.passenger.api.models.ApiCancellationVoucherRequest
import com.ioki.passenger.api.models.ApiCaptchaRequest
import com.ioki.passenger.api.models.ApiClientChallengeRequest
import com.ioki.passenger.api.models.ApiCreateLogPayPaymentMethodRequest
import com.ioki.passenger.api.models.ApiCreateTipRequest
import com.ioki.passenger.api.models.ApiDeviceRequest
import com.ioki.passenger.api.models.ApiDoorStateChangeRequest
import com.ioki.passenger.api.models.ApiFailedPaymentRequest
import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest
import com.ioki.passenger.api.models.ApiGeocodingDetailsRequest
import com.ioki.passenger.api.models.ApiGeocodingSearchRequest
import com.ioki.passenger.api.models.ApiGeocodingSessionRequest
import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiPaymentMethodCreationRequest
import com.ioki.passenger.api.models.ApiPersonalDiscountPurchaseRequest
import com.ioki.passenger.api.models.ApiPhoneVerificationRequest
import com.ioki.passenger.api.models.ApiPurchaseFilter
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest
import com.ioki.passenger.api.models.ApiRatingRequest
import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest
import com.ioki.passenger.api.models.ApiRedeemReferralCodeRequest
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest
import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiResettleDebitsRequest
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import com.ioki.passenger.api.models.ApiRideRequest
import com.ioki.passenger.api.models.ApiRideSeriesRequest
import com.ioki.passenger.api.models.ApiSettleDebitRequest
import com.ioki.passenger.api.models.ApiSignUpRequest
import com.ioki.passenger.api.models.ApiUpdatePassengersForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePaymentMethodForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest
import com.ioki.passenger.api.models.ApiUpdateUserRequest
import com.ioki.passenger.api.models.ApiUserFlagsRequest
import com.ioki.passenger.api.models.ApiUserTicketingVouchersFilter
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.parameters
import io.ktor.util.StringValues
import kotlinx.serialization.json.Json
import kotlin.time.Instant

internal class IokiApi(private val client: IokiHttpClient) {
    suspend fun requestPhoneVerification(body: ApiBody<ApiPhoneVerificationRequest>): HttpResponse =
        client.post("/api/passenger/phone_verification_requests") {
            setBody(body)
        }

    suspend fun requestApiToken(body: ApiBody<ApiRequestTokenRequest>): HttpResponse =
        client.post("/api/passenger/request_tokens") {
            setBody(body)
        }

    suspend fun signUp(body: ApiBody<ApiSignUpRequest>): HttpResponse = client.put("/api/passenger/user") {
        setBody(body)
    }

    suspend fun updateUser(body: ApiBody<ApiUpdateUserRequest>): HttpResponse = client.patch("/api/passenger/user") {
        setBody(body)
    }

    suspend fun getUser(): HttpResponse = client.get("/api/passenger/user")

    suspend fun deleteUser(): HttpResponse = client.post("/api/passenger/user/deletion_request")

    suspend fun logoutUser(): HttpResponse = client.post("/api/passenger/user/logout")

    suspend fun createRide(body: ApiBody<ApiRideRequest>): HttpResponse = client.post("/api/passenger/rides") {
        setBody(body)
    }

    suspend fun getRide(rideId: String): HttpResponse = client.get("/api/passenger/rides/$rideId")

    suspend fun getCurrentRide(): HttpResponse = client.get("/api/passenger/rides/current")

    suspend fun createBooking(rideId: String, body: ApiBody<ApiBookingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/booking") {
            setBody(body)
        }

    suspend fun getRides(type: String, page: Int = 1, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/rides") {
            url.parameters.appendAll(
                parameters {
                    append("filter", type)
                    append("page", page.toString())
                    append("per_page", perPage.toString())
                },
            )
        }

    suspend fun getRideSeriesList(page: Int = 1, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ride_series") {
            url.parameters.appendAll(
                parameters {
                    append("page", page.toString())
                    append("per_page", perPage.toString())
                },
            )
        }

    suspend fun getRideSeries(rideSeriesId: String): HttpResponse =
        client.get("/api/passenger/ride_series/$rideSeriesId")

    suspend fun createRideSeries(rideId: String, body: ApiBody<ApiRideSeriesRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/ride_series") {
            setBody(body)
        }

    suspend fun submitRating(rideId: String, body: ApiBody<ApiRatingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/rating") {
            setBody(body)
        }

    suspend fun getCancellationVoucher(rideId: String, body: ApiBody<ApiCancellationVoucherRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/cancellation_voucher") {
            setBody(body)
        }

    suspend fun cancelRide(rideId: String, body: ApiBody<ApiCancellationRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/cancellation") {
            setBody(body)
        }

    suspend fun createDevice(body: ApiBody<ApiDeviceRequest>): HttpResponse = client.post("/api/passenger/devices") {
        setBody(body)
    }

    suspend fun getClient(): HttpResponse = client.get("/api/passenger/client")

    suspend fun requestPhoneCall(rideId: String): HttpResponse =
        client.post("/api/passenger/rides/$rideId/phone_call")

    suspend fun getServiceCreditPackages(): HttpResponse = client.get("/api/passenger/service_credits")

    suspend fun purchaseCreditPackage(body: ApiBody<ApiPurchasingCreditPackageRequest>): HttpResponse =
        client.post("/api/passenger/service_credits") {
            setBody(body)
        }

    suspend fun getBootstrap(): HttpResponse = client.get("/api/passenger/bootstrap") {
    }

    suspend fun getAvailablePersonalDiscountTypes(): HttpResponse =
        client.get("/api/passenger/personal_discount_types") {
        }

    suspend fun getMyPersonalDiscounts(): HttpResponse = client.get("/api/passenger/personal_discounts")

    suspend fun purchasePersonalDiscount(body: ApiBody<ApiPersonalDiscountPurchaseRequest>): HttpResponse =
        client.post("/api/passenger/personal_discounts") {
            setBody(body)
        }

    suspend fun redeemPromoCode(body: ApiBody<ApiRedeemPromoCodeRequest>): HttpResponse =
        client.post("/api/passenger/redeemed_promo_codes") {
            setBody(body)
        }

    suspend fun getRedeemedPromoCodes(): HttpResponse = client.get("/api/passenger/redeemed_promo_codes")

    suspend fun getFirebaseToken(): HttpResponse = client.get("/api/passenger/firebase_token")

    suspend fun requestPublicTransportSchedules(url: String, time: Instant): HttpResponse = client.get(url) {
        url {
            url(url)
            parameters.appendAll(
                parameters {
                    append("time", time.toString())
                },
            )
        }
    }

    suspend fun requestStripeSetupIntent(): HttpResponse = client.post("/api/passenger/payment_methods/setup_intent")

    suspend fun createPaymentMethod(body: ApiBody<ApiPaymentMethodCreationRequest>): HttpResponse =
        client.post("/api/passenger/payment_methods") {
            setBody(body)
        }

    suspend fun detachPaymentMethod(paymentMethodId: String): HttpResponse =
        client.delete("/api/passenger/payment_methods/$paymentMethodId") {
        }

    suspend fun getPaymentMethods(): HttpResponse = client.get("/api/passenger/payment_methods")

    suspend fun updateLanguage(): HttpResponse = client.patch("/api/passenger/user/language")

    suspend fun redeemReferralCode(body: ApiBody<ApiRedeemReferralCodeRequest>): HttpResponse =
        client.post("/api/passenger/user/referral") {
            setBody(body)
        }

    suspend fun marketingApproval(): HttpResponse = client.post("/api/passenger/user/marketing_approval")

    suspend fun marketingRejection(): HttpResponse = client.post("/api/passenger/user/marketing_rejection")

    suspend fun updatePhoneNumber(body: ApiBody<ApiUpdatePhoneNumberRequest>): HttpResponse =
        client.patch("/api/passenger/user/phone_number") {
            setBody(body)
        }

    suspend fun createLogPayCustomer(body: ApiBody<ApiLogPayAccountRequest>): HttpResponse =
        client.post("/api/passenger/logpay/customer") {
            setBody(body)
        }

    suspend fun getLogPayUrl(body: ApiBody<ApiCreateLogPayPaymentMethodRequest>): HttpResponse =
        client.post("/api/passenger/logpay/payment_method") {
            setBody(body)
        }

    suspend fun createPaypalClientToken(): HttpResponse = client.post("/api/passenger/logpay/paypal_client_token")

    suspend fun calculateNewFareForRide(rideId: String, body: ApiBody<ApiCalculateNewFareRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/fare_preview") {
            setBody(body)
        }

    suspend fun updatePassengersForRide(
        rideId: String,
        body: ApiBody<ApiUpdatePassengersForRideRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/passengers") {
        setBody(body)
    }

    suspend fun updatePaymentMethodForRide(
        rideId: String,
        body: ApiBody<ApiUpdatePaymentMethodForRideRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/payment_method") {
        setBody(body)
    }

    suspend fun sendTip(rideId: String, body: ApiBody<ApiCreateTipRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/tip") {
            setBody(body)
        }

    suspend fun changeDoorState(rideId: String, body: ApiBody<ApiDoorStateChangeRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/vehicle/hardware/door_state_change_request") {
            setBody(body)
        }

    suspend fun payFailedPayments(body: ApiBody<ApiFailedPaymentRequest>): HttpResponse =
        client.post("/api/passenger/rides/retry_payment") {
            setBody(body)
        }

    suspend fun updateUserFlags(body: ApiBody<ApiUserFlagsRequest>): HttpResponse =
        client.post("/api/passenger/user/flags") {
            setBody(body)
        }

    suspend fun inquireRide(body: ApiBody<ApiRideInquiryRequest>): HttpResponse =
        client.post("/api/passenger/ride_inquiry") {
            setBody(body)
        }

    suspend fun getStations(
        query: String,
        productId: String,
        xmin: Float?,
        xmax: Float?,
        ymin: Float?,
        ymax: Float?,
    ): HttpResponse = client.get("/api/passenger/stations") {
        url.parameters.appendAll(
            parameters {
                append("query", query)
                append("product_id", productId)
                xmin?.let { append("xmin", it.toString()) }
                xmax?.let { append("xmax", it.toString()) }
                ymin?.let { append("ymin", it.toString()) }
                ymax?.let { append("ymax", it.toString()) }
            },
        )
    }

    suspend fun getVenues(): HttpResponse = client.get("/api/passenger/venues")

    suspend fun sendFirebaseDebugRecord(id: String, body: ApiBody<ApiFirebaseDebugRecordRequest>): HttpResponse =
        client.post("/api/passenger/firebase_debug_records/$id/confirm") {
            setBody(body)
        }

    suspend fun solveCaptcha(id: String, body: ApiBody<ApiCaptchaRequest>): HttpResponse =
        client.post("/api/passenger/captchas/$id/solution") {
            setBody(body)
        }

    suspend fun solveClientChallenge(id: String, body: ApiBody<ApiClientChallengeRequest>): HttpResponse =
        client.post("/api/passenger/client_challenges/$id/solution") {
            setBody(body)
        }

    suspend fun getUserNotificationSettings(): HttpResponse = client.get("/api/passenger/notification_settings")

    suspend fun getAvailableProviderNotificationSettings(): HttpResponse =
        client.get("/api/passenger/notification_settings/available")

    suspend fun getDefaultProviderNotificationSettings(): HttpResponse =
        client.get("/api/passenger/notification_settings/defaults")

    suspend fun updateUserNotificationSettings(
        userId: String,
        body: ApiBody<ApiUpdateUserNotificationSettingsRequest>,
    ): HttpResponse = client.patch("/api/passenger/notification_settings/$userId") {
        setBody(body)
    }

    suspend fun getAllTicketingProducts(
        filter: String,
        rideId: String?,
        ticketFilter: Map<String, String>,
        page: Int = 1,
        perPage: Int = 10,
    ): HttpResponse = client.get("/api/passenger/ticketing/products") {
        url.parameters.appendAll(
            parameters {
                append("filter", filter)
                rideId?.let { append("ride_id", it) }
                ticketFilter.forEach { (key, value) ->
                    append(key, value)
                }
                append("page", page.toString())
                append("per_page", perPage.toString())
            },
        )
    }

    suspend fun orderTicketingProduct(id: String, body: ApiBody<ApiPurchaseTicketingProductRequest>): HttpResponse =
        client.post("/api/passenger/ticketing/products/$id/order") {
            setBody(body)
        }

    suspend fun preorderTicketingProduct(id: String, body: ApiBody<ApiPurchaseTicketingProductRequest>): HttpResponse =
        client.post("/api/passenger/ticketing/products/$id/preorder") {
            setBody(body)
        }

    suspend fun cancelPreorderedTicketingVoucher(id: String): HttpResponse =
        client.post("/api/passenger/ticketing/vouchers/$id/cancellation")

    suspend fun getUserTicketingVouchers(
        page: Int,
        filter: ApiUserTicketingVouchersFilter,
        perPage: Int = 10,
    ): HttpResponse = client.get("/api/passenger/ticketing/vouchers") {
        url.parameters.appendAll(
            parameters {
                append("page", page.toString())
                append("filter", filter.queryValue)
                append("per_page", perPage.toString())
            },
        )
    }

    suspend fun getUserTicketingVoucher(id: String): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers/$id")

    suspend fun renewUserTicketingVoucher(id: String, body: ApiBody<ApiRenewTicketingVoucherRequest>): HttpResponse =
        client.post("/api/passenger/ticketing/vouchers/$id/renewal") {
            setBody(body)
        }

    suspend fun cancelTicketingVoucherSubscription(id: String): HttpResponse =
        client.post("/api/passenger/ticketing/vouchers/$id/subscription_cancellation")

    suspend fun getTicketShopConfiguration(): HttpResponse = client.get("/api/passenger/ticketing/shop_config")

    suspend fun getRatingCriteria(rideId: String): HttpResponse =
        client.get("/api/passenger/rides/$rideId/rating_criteria") {
        }

    suspend fun getPurchases(filter: ApiPurchaseFilter): HttpResponse = client.get("/api/passenger/purchases") {
        url.parameters.appendAll(filter.toStringValues())
    }

    suspend fun getPurchase(id: String): HttpResponse = client.get("/api/passenger/purchases/$id")

    suspend fun settleDebit(purchaseId: String, body: ApiBody<ApiSettleDebitRequest>): HttpResponse =
        client.patch("/api/passenger/purchases/$purchaseId/settle_debit") {
            setBody(body)
        }

    suspend fun resettleDebits(body: ApiBody<ApiResettleDebitsRequest>): HttpResponse =
        client.patch("/api/passenger/purchases/resettle_debits") {
            setBody(body)
        }

    suspend fun geocodingSession(body: ApiBody<ApiGeocodingSessionRequest>): HttpResponse =
        client.post("/api/passenger/geocoding/session") {
            setBody(body)
        }

    suspend fun expireGeocodingSession(id: String): HttpResponse =
        client.delete("/api/passenger/geocoding/session/$id") {
        }

    suspend fun geocodingSearch(id: String, body: ApiBody<ApiGeocodingSearchRequest>): HttpResponse =
        client.post("/api/passenger/geocoding/session/$id/search") {
            setBody(body)
        }

    suspend fun geocodingDetails(id: String, body: ApiBody<ApiGeocodingDetailsRequest>): HttpResponse =
        client.post("/api/passenger/geocoding/session/$id/details") {
            setBody(body)
        }

    suspend fun getNotification(id: String): HttpResponse = client.get("/api/passenger/notifications/$id")
}

private fun ApiPurchaseFilter.toStringValues(): StringValues = StringValues.build {
    append(name = "page", value = page.toString())
    perPage?.let { append(name = "per_page", value = it.toString()) }
    since?.let { append(name = "since", value = it.toString()) }
    until?.let { append(name = "until", value = it.toString()) }
    purchasableId?.let { append(name = "purchasable_id", value = it) }
    purchasableType?.let {
        append(name = "purchasable_type", value = Json.encodeToString(value = it).removeSurrounding(delimiter = "\""))
    }
    state?.let { append(name = "state", value = Json.encodeToString(value = it).removeSurrounding(delimiter = "\"")) }
    filter?.let { append(name = "filter", value = Json.encodeToString(value = it).removeSurrounding(delimiter = "\"")) }
    order?.let { append(name = "order", value = Json.encodeToString(value = it).removeSurrounding(delimiter = "\"")) }
    orderBy?.let {
        append(name = "order_by", value = Json.encodeToString(value = it).removeSurrounding(delimiter = "\""))
    }
}
