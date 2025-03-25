package com.ioki.passenger.api.internal.api

import com.ioki.passenger.api.internal.IokiHttpClient
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
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
import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiPaymentMethodCreationRequest
import com.ioki.passenger.api.models.ApiPersonalDiscountPurchaseRequest
import com.ioki.passenger.api.models.ApiPhoneVerificationRequest
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest
import com.ioki.passenger.api.models.ApiRatingRequest
import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest
import com.ioki.passenger.api.models.ApiRedeemReferralCodeRequest
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest
import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import com.ioki.passenger.api.models.ApiRideRequest
import com.ioki.passenger.api.models.ApiRideSeriesRequest
import com.ioki.passenger.api.models.ApiSignUpRequest
import com.ioki.passenger.api.models.ApiUpdatePassengersForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePaymentMethodForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest
import com.ioki.passenger.api.models.ApiUpdateUserRequest
import com.ioki.passenger.api.models.ApiUserFlagsRequest
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.parameters
import kotlinx.datetime.Instant

internal class IokiApi(
    private val client: IokiHttpClient,
    private val authHeaderProvider: AuthHeaderProvider,
) {
    private val accessToken get() = authHeaderProvider.provide()

    suspend fun requestPhoneVerification(body: ApiBody<ApiPhoneVerificationRequest>): HttpResponse =
        client.post("/api/passenger/phone_verification_requests") {
            setBody(body)
        }

    suspend fun requestApiToken(body: ApiBody<ApiRequestTokenRequest>): HttpResponse =
        client.post("/api/passenger/request_tokens") {
            setBody(body)
        }

    suspend fun signUp(body: ApiBody<ApiSignUpRequest>): HttpResponse = client.put("/api/passenger/user") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun updateUser(body: ApiBody<ApiUpdateUserRequest>): HttpResponse = client.patch("/api/passenger/user") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getUser(): HttpResponse = client.get("/api/passenger/user") {
        header("Authorization", accessToken)
    }

    suspend fun deleteUser(): HttpResponse = client.post("/api/passenger/user/deletion_request") {
        header("Authorization", accessToken)
    }

    suspend fun createRide(body: ApiBody<ApiRideRequest>): HttpResponse = client.post("/api/passenger/rides") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getRide(rideId: String): HttpResponse = client.get("/api/passenger/rides/$rideId") {
        header("Authorization", accessToken)
    }

    suspend fun getCurrentRide(): HttpResponse = client.get("/api/passenger/rides/current") {
        header("Authorization", accessToken)
    }

    suspend fun createBooking(rideId: String, body: ApiBody<ApiBookingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/booking") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getRides(type: String, page: Int = 1, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/rides") {
            header("Authorization", accessToken)
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
            header("Authorization", accessToken)
            url.parameters.appendAll(
                parameters {
                    append("page", page.toString())
                    append("per_page", perPage.toString())
                },
            )
        }

    suspend fun getRideSeries(rideSeriesId: String): HttpResponse =
        client.get("/api/passenger/ride_series/$rideSeriesId") {
            header("Authorization", accessToken)
        }

    suspend fun createRideSeries(rideId: String, body: ApiBody<ApiRideSeriesRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/ride_series") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun submitRating(rideId: String, body: ApiBody<ApiRatingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/rating") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getCancellationVoucher(rideId: String, body: ApiBody<ApiCancellationVoucherRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/cancellation_voucher") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun cancelRide(rideId: String, body: ApiBody<ApiCancellationRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/cancellation") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createDevice(body: ApiBody<ApiDeviceRequest>): HttpResponse = client.post("/api/passenger/devices") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getClient(): HttpResponse = client.get("/api/passenger/client")

    suspend fun requestPhoneCall(rideId: String): HttpResponse =
        client.post("/api/passenger/rides/$rideId/phone_call") {
            header("Authorization", accessToken)
        }

    suspend fun getServiceCreditPackages(): HttpResponse = client.get("/api/passenger/service_credits") {
        header("Authorization", accessToken)
    }

    suspend fun purchaseCreditPackage(body: ApiBody<ApiPurchasingCreditPackageRequest>): HttpResponse =
        client.post("/api/passenger/service_credits") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getBootstrap(): HttpResponse = client.get("/api/passenger/bootstrap") {
        header("Authorization", accessToken)
    }

    suspend fun getAvailablePersonalDiscountTypes(): HttpResponse =
        client.get("/api/passenger/personal_discount_types") {
            header("Authorization", accessToken)
        }

    suspend fun getMyPersonalDiscounts(): HttpResponse = client.get("/api/passenger/personal_discounts") {
        header("Authorization", accessToken)
    }

    suspend fun purchasePersonalDiscount(body: ApiBody<ApiPersonalDiscountPurchaseRequest>): HttpResponse =
        client.post("/api/passenger/personal_discounts") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun redeemPromoCode(body: ApiBody<ApiRedeemPromoCodeRequest>): HttpResponse =
        client.post("/api/passenger/redeemed_promo_codes") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getRedeemedPromoCodes(): HttpResponse = client.get("/api/passenger/redeemed_promo_codes") {
        header("Authorization", accessToken)
    }

    suspend fun getFirebaseToken(): HttpResponse = client.get("/api/passenger/firebase_token") {
        header("Authorization", accessToken)
    }

    suspend fun requestPublicTransportSchedules(url: String, time: Instant): HttpResponse = client.get(url) {
        header("Authorization", accessToken)
        url {
            url(url)
            parameters.appendAll(
                parameters {
                    append("time", time.toString())
                },
            )
        }
    }

    suspend fun requestStripeSetupIntent(): HttpResponse = client.post("/api/passenger/payment_methods/setup_intent") {
        header("Authorization", accessToken)
    }

    suspend fun createPaymentMethod(body: ApiBody<ApiPaymentMethodCreationRequest>): HttpResponse =
        client.post("/api/passenger/payment_methods") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun detachPaymentMethod(paymentMethodId: String): HttpResponse =
        client.delete("/api/passenger/payment_methods/$paymentMethodId") {
            header("Authorization", accessToken)
        }

    suspend fun getPaymentMethods(): HttpResponse = client.get("/api/passenger/payment_methods") {
        header("Authorization", accessToken)
    }

    suspend fun updateLanguage(): HttpResponse = client.patch("/api/passenger/user/language") {
        header("Authorization", accessToken)
    }

    suspend fun redeemReferralCode(body: ApiBody<ApiRedeemReferralCodeRequest>): HttpResponse =
        client.post("/api/passenger/user/referral") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun marketingApproval(): HttpResponse = client.post("/api/passenger/user/marketing_approval") {
        header("Authorization", accessToken)
    }

    suspend fun marketingRejection(): HttpResponse = client.post("/api/passenger/user/marketing_rejection") {
        header("Authorization", accessToken)
    }

    suspend fun updatePhoneNumber(body: ApiBody<ApiUpdatePhoneNumberRequest>): HttpResponse =
        client.patch("/api/passenger/user/phone_number") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createLogPayCustomer(body: ApiBody<ApiLogPayAccountRequest>): HttpResponse =
        client.post("/api/passenger/logpay/customer") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getLogPayUrl(body: ApiBody<ApiCreateLogPayPaymentMethodRequest>): HttpResponse =
        client.post("/api/passenger/logpay/payment_method") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createPaypalClientToken(): HttpResponse = client.post("/api/passenger/logpay/paypal_client_token") {
        header("Authorization", accessToken)
    }

    suspend fun calculateNewFareForRide(rideId: String, body: ApiBody<ApiCalculateNewFareRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/fare_preview") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun updatePassengersForRide(
        rideId: String,
        body: ApiBody<ApiUpdatePassengersForRideRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/passengers") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun updatePaymentMethodForRide(
        rideId: String,
        body: ApiBody<ApiUpdatePaymentMethodForRideRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/payment_method") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun sendTip(rideId: String, body: ApiBody<ApiCreateTipRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/tip") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun changeDoorState(rideId: String, body: ApiBody<ApiDoorStateChangeRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/vehicle/hardware/door_state_change_request") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun payFailedPayments(body: ApiBody<ApiFailedPaymentRequest>): HttpResponse =
        client.post("/api/passenger/rides/retry_payment") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun updateUserFlags(body: ApiBody<ApiUserFlagsRequest>): HttpResponse =
        client.post("/api/passenger/user/flags") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun inquireRide(body: ApiBody<ApiRideInquiryRequest>): HttpResponse =
        client.post("/api/passenger/ride_inquiry") {
            header("Authorization", accessToken)
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
        header("Authorization", accessToken)
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

    suspend fun getVenues(): HttpResponse = client.get("/api/passenger/venues") {
        header("Authorization", accessToken)
    }

    suspend fun sendFirebaseDebugRecord(id: String, body: ApiBody<ApiFirebaseDebugRecordRequest>): HttpResponse =
        client.post("/api/passenger/firebase_debug_records/$id/confirm") {
            header("Authorization", accessToken)
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

    suspend fun getUserNotificationSettings(): HttpResponse = client.get("/api/passenger/notification_settings") {
        header("Authorization", accessToken)
    }

    suspend fun getAvailableProviderNotificationSettings(): HttpResponse =
        client.get("/api/passenger/notification_settings/available") {
            header("Authorization", accessToken)
        }

    suspend fun getDefaultProviderNotificationSettings(): HttpResponse =
        client.get("/api/passenger/notification_settings/defaults") {
            header("Authorization", accessToken)
        }

    suspend fun updateUserNotificationSettings(
        userId: String,
        body: ApiBody<ApiUpdateUserNotificationSettingsRequest>,
    ): HttpResponse = client.patch("/api/passenger/notification_settings/$userId") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getAllTicketingProducts(
        filter: String,
        rideId: String?,
        page: Int = 1,
        perPage: Int = 10,
    ): HttpResponse = client.get("/api/passenger/ticketing/products") {
        header("Authorization", accessToken)
        url.parameters.appendAll(
            parameters {
                append("filter", filter)
                rideId?.let { append("ride_id", it.toString()) }
                append("page", page.toString())
                append("per_page", perPage.toString())
            },
        )
    }

    suspend fun purchaseTicketingProduct(id: String, body: ApiBody<ApiPurchaseTicketingProductRequest>): HttpResponse =
        client.post("/api/passenger/ticketing/products/$id/purchase") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getActiveUserTicketingVouchers(page: Int, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers") {
            header("Authorization", accessToken)
            url.parameters.appendAll(
                parameters {
                    append("page", page.toString())
                    append("filter", "active")
                    append("per_page", perPage.toString())
                },
            )
        }

    suspend fun getInactiveUserTicketingVouchers(page: Int, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers") {
            header("Authorization", accessToken)
            url.parameters.appendAll(
                parameters {
                    append("page", page.toString())
                    append("filter", "inactive")
                    append("per_page", perPage.toString())
                },
            )
        }

    suspend fun getUserTicketingVoucher(id: String): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers/$id") {
            header("Authorization", accessToken)
        }

    suspend fun renewUserTicketingVoucher(id: String, body: ApiBody<ApiRenewTicketingVoucherRequest>): HttpResponse =
        client.post("/api/passenger/ticketing/vouchers/$id/renewal") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun cancelUserTicketingVoucher(id: String): HttpResponse =
        client.post("/api/passenger/ticketing/vouchers/$id/subscription_cancellation") {
            header("Authorization", accessToken)
        }

    suspend fun getTicketShopConfiguration(): HttpResponse = client.get("/api/passenger/ticketing/shop_config") {
        header("Authorization", accessToken)
    }

    suspend fun getRatingCriteria(rideId: String): HttpResponse =
        client.get("/api/passenger/rides/$rideId/rating_criteria") {
            header("Authorization", accessToken)
        }
}
