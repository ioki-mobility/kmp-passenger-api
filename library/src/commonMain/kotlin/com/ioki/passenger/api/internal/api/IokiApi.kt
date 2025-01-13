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
import io.ktor.client.statement.HttpResponse
import io.ktor.http.parameters
import kotlinx.datetime.Instant

internal class IokiApi(private val client: IokiHttpClient) {
    suspend fun requestPhoneVerification(body: ApiBody<ApiPhoneVerificationRequest>): HttpResponse =
        client.post("/api/passenger/phone_verification_requests") {
            setBody(body)
        }

    suspend fun requestApiToken(body: ApiBody<ApiRequestTokenRequest>): HttpResponse =
        client.post("/api/passenger/request_tokens") {
            setBody(body)
        }

    suspend fun signUp(accessToken: String, body: ApiBody<ApiSignUpRequest>): HttpResponse =
        client.put("/api/passenger/user") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun updateUser(accessToken: String, body: ApiBody<ApiUpdateUserRequest>): HttpResponse =
        client.patch("/api/passenger/user") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getUser(accessToken: String): HttpResponse = client.get("/api/passenger/user") {
        header("Authorization", accessToken)
    }

    suspend fun deleteUser(accessToken: String): HttpResponse = client.post("/api/passenger/user/deletion_request") {
        header("Authorization", accessToken)
    }

    suspend fun createRide(accessToken: String, body: ApiBody<ApiRideRequest>): HttpResponse =
        client.post("/api/passenger/rides") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getRide(accessToken: String, rideId: String): HttpResponse =
        client.get("/api/passenger/rides/$rideId") {
            header("Authorization", accessToken)
        }

    suspend fun getCurrentRide(accessToken: String): HttpResponse = client.get("/api/passenger/rides/current") {
        header("Authorization", accessToken)
    }

    suspend fun createBooking(accessToken: String, rideId: String, body: ApiBody<ApiBookingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/booking") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getRides(accessToken: String, type: String, page: Int = 1, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/rides") {
            header("Authorization", accessToken)
            parameters {
                append("filter", type)
                append("page", page.toString())
                append("per_page", perPage.toString())
            }
        }

    suspend fun getRideSeriesList(accessToken: String, page: Int = 1, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ride_series") {
            header("Authorization", accessToken)
            parameters {
                append("page", page.toString())
                append("per_page", perPage.toString())
            }
        }

    suspend fun getRideSeries(accessToken: String, rideSeriesId: String): HttpResponse =
        client.get("/api/passenger/ride_series/$rideSeriesId") {
            header("Authorization", accessToken)
        }

    suspend fun createRideSeries(
        accessToken: String,
        rideId: String,
        body: ApiBody<ApiRideSeriesRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/ride_series") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun submitRating(accessToken: String, rideId: String, body: ApiBody<ApiRatingRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/rating") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getCancellationVoucher(
        accessToken: String,
        rideId: String,
        body: ApiBody<ApiCancellationVoucherRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/cancellation_voucher") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun cancelRide(accessToken: String, rideId: String, body: ApiBody<ApiCancellationRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/cancellation") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createDevice(accessToken: String, body: ApiBody<ApiDeviceRequest>): HttpResponse =
        client.post("/api/passenger/devices") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getClient(): HttpResponse = client.get("/api/passenger/client")

    suspend fun requestPhoneCall(accessToken: String, rideId: String): HttpResponse =
        client.post("/api/passenger/rides/$rideId/phone_call") {
            header("Authorization", accessToken)
        }

    suspend fun getServiceCreditPackages(accessToken: String): HttpResponse =
        client.get("/api/passenger/service_credits") {
            header("Authorization", accessToken)
        }

    suspend fun purchaseCreditPackage(
        accessToken: String,
        body: ApiBody<ApiPurchasingCreditPackageRequest>,
    ): HttpResponse = client.post("/api/passenger/service_credits") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getBootstrap(accessToken: String): HttpResponse = client.get("/api/passenger/bootstrap") {
        header("Authorization", accessToken)
    }

    suspend fun getAvailablePersonalDiscountTypes(accessToken: String): HttpResponse =
        client.get("/api/passenger/personal_discount_types") {
            header("Authorization", accessToken)
        }

    suspend fun getMyPersonalDiscounts(accessToken: String): HttpResponse =
        client.get("/api/passenger/personal_discounts") {
            header("Authorization", accessToken)
        }

    suspend fun purchasePersonalDiscount(
        accessToken: String,
        body: ApiBody<ApiPersonalDiscountPurchaseRequest>,
    ): HttpResponse = client.post("/api/passenger/personal_discounts") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun redeemPromoCode(accessToken: String, body: ApiBody<ApiRedeemPromoCodeRequest>): HttpResponse =
        client.post("/api/passenger/redeemed_promo_codes") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getRedeemedPromoCodes(accessToken: String): HttpResponse =
        client.get("/api/passenger/redeemed_promo_codes") {
            header("Authorization", accessToken)
        }

    suspend fun getFirebaseToken(accessToken: String): HttpResponse = client.get("/api/passenger/firebase_token") {
        header("Authorization", accessToken)
    }

    suspend fun requestPublicTransportSchedules(accessToken: String, url: String, time: Instant): HttpResponse =
        client.get(url) {
            header("Authorization", accessToken)
            parameters {
                append("time", time.toString())
            }
        }

    suspend fun requestStripeSetupIntent(accessToken: String): HttpResponse =
        client.post("/api/passenger/payment_methods/setup_intent") {
            header("Authorization", accessToken)
        }

    suspend fun createPaymentMethod(
        accessToken: String,
        body: ApiBody<ApiPaymentMethodCreationRequest>,
    ): HttpResponse = client.post("/api/passenger/payment_methods") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun detachPaymentMethod(accessToken: String, paymentMethodId: String): HttpResponse =
        client.delete("/api/passenger/payment_methods/$paymentMethodId") {
            header("Authorization", accessToken)
        }

    suspend fun getPaymentMethods(accessToken: String): HttpResponse = client.get("/api/passenger/payment_methods") {
        header("Authorization", accessToken)
    }

    suspend fun updateLanguage(accessToken: String): HttpResponse = client.patch("/api/passenger/user/language") {
        header("Authorization", accessToken)
    }

    suspend fun redeemReferralCode(accessToken: String, body: ApiBody<ApiRedeemReferralCodeRequest>): HttpResponse =
        client.post("/api/passenger/user/referral") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun marketingApproval(accessToken: String): HttpResponse =
        client.post("/api/passenger/user/marketing_approval") {
            header("Authorization", accessToken)
        }

    suspend fun marketingRejection(accessToken: String): HttpResponse =
        client.post("/api/passenger/user/marketing_rejection") {
            header("Authorization", accessToken)
        }

    suspend fun updatePhoneNumber(accessToken: String, body: ApiBody<ApiUpdatePhoneNumberRequest>): HttpResponse =
        client.patch("/api/passenger/user/phone_number") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createLogPayCustomer(accessToken: String, body: ApiBody<ApiLogPayAccountRequest>): HttpResponse =
        client.post("/api/passenger/logpay/customer") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getLogPayUrl(accessToken: String, body: ApiBody<ApiCreateLogPayPaymentMethodRequest>): HttpResponse =
        client.post("/api/passenger/logpay/payment_method") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun createPaypalClientToken(accessToken: String): HttpResponse =
        client.post("/api/passenger/logpay/paypal_client_token") {
            header("Authorization", accessToken)
        }

    suspend fun calculateNewFareForRide(
        accessToken: String,
        rideId: String,
        body: ApiBody<ApiCalculateNewFareRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/fare_preview") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun updatePassengersForRide(
        accessToken: String,
        rideId: String,
        body: ApiBody<ApiUpdatePassengersForRideRequest>,
    ): HttpResponse = client.post("/api/passenger/rides/$rideId/passengers") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun sendTip(accessToken: String, rideId: String, body: ApiBody<ApiCreateTipRequest>): HttpResponse =
        client.post("/api/passenger/rides/$rideId/tip") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun changeDoorState(
        accessToken: String,
        rideId: String,
        body: ApiBody<ApiDoorStateChangeRequest>,
    ): HttpResponse =
        client.post("/api/passenger/rides/$rideId/vehicle/hardware/door_state_change_request") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun payFailedPayments(accessToken: String, body: ApiBody<ApiFailedPaymentRequest>): HttpResponse =
        client.post("/api/passenger/rides/retry_payment") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun updateUserFlags(accessToken: String, body: ApiBody<ApiUserFlagsRequest>): HttpResponse =
        client.post("/api/passenger/user/flags") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun inquireRide(accessToken: String, body: ApiBody<ApiRideInquiryRequest>): HttpResponse =
        client.post("/api/passenger/ride_inquiry") {
            header("Authorization", accessToken)
            setBody(body)
        }

    suspend fun getStations(
        accessToken: String,
        query: String,
        productId: String,
        xmin: Float?,
        xmax: Float?,
        ymin: Float?,
        ymax: Float?,
    ): HttpResponse = client.get("/api/passenger/stations") {
        header("Authorization", accessToken)
        parameters {
            append("query", query)
            append("product_id", productId)
            append("xmin", xmin.toString())
            append("xmax", xmax.toString())
            append("ymin", ymin.toString())
            append("ymax", ymax.toString())
        }
    }

    suspend fun getVenues(accessToken: String): HttpResponse = client.get("/api/passenger/venues") {
        header("Authorization", accessToken)
    }

    suspend fun sendFirebaseDebugRecord(
        accessToken: String,
        id: String,
        body: ApiBody<ApiFirebaseDebugRecordRequest>,
    ): HttpResponse = client.post("/api/passenger/firebase_debug_records/$id/confirm") {
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

    suspend fun getUserNotificationSettings(accessToken: String): HttpResponse =
        client.get("/api/passenger/notification_settings") {
            header("Authorization", accessToken)
        }

    suspend fun getAvailableProviderNotificationSettings(accessToken: String): HttpResponse =
        client.get("/api/passenger/notification_settings/available") {
            header("Authorization", accessToken)
        }

    suspend fun getDefaultProviderNotificationSettings(accessToken: String): HttpResponse =
        client.get("/api/passenger/notification_settings/defaults") {
            header("Authorization", accessToken)
        }

    suspend fun updateUserNotificationSettings(
        accessToken: String,
        userId: String,
        body: ApiBody<ApiUpdateUserNotificationSettingsRequest>,
    ): HttpResponse = client.patch("/api/passenger/notification_settings/$userId") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getAllTicketingProducts(
        accessToken: String,
        filter: String,
        rideId: String?,
        page: Int = 1,
        perPage: Int = 10,
    ): HttpResponse = client.get("/api/passenger/ticketing/products") {
        header("Authorization", accessToken)
        parameters {
            append("filter", filter)
            append("ride_id", rideId.toString())
            append("page", page.toString())
            append("per_page", perPage.toString())
        }
    }

    suspend fun purchaseTicketingProduct(
        accessToken: String,
        id: String,
        body: ApiBody<ApiPurchaseTicketingProductRequest>,
    ): HttpResponse = client.post("/api/passenger/ticketing/products/$id/purchase") {
        header("Authorization", accessToken)
        setBody(body)
    }

    suspend fun getActiveUserTicketingVouchers(accessToken: String, page: Int, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers") {
            header("Authorization", accessToken)
            parameters {
                append("page", page.toString())
                append("filter", "active")
                append("per_page", perPage.toString())
            }
        }

    suspend fun getInactiveUserTicketingVouchers(accessToken: String, page: Int, perPage: Int = 10): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers") {
            header("Authorization", accessToken)
            parameters {
                append("page", page.toString())
                append("filter", "inactive")
                append("per_page", perPage.toString())
            }
        }

    suspend fun getUserTicketingVoucher(accessToken: String, id: String): HttpResponse =
        client.get("/api/passenger/ticketing/vouchers/$id") {
            header("Authorization", accessToken)
        }

    suspend fun renewUserTicketingVoucher(
        accessToken: String,
        id: String,
        body: ApiBody<ApiRenewTicketingVoucherRequest>,
    ): HttpResponse = client.post("/api/passenger/ticketing/vouchers/$id/renewal") {
        header("Authorization", accessToken)
        setBody(body)
    }
}
