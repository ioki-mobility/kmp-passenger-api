package com.ioki.passenger.api

import com.ioki.passenger.api.internal.IokiHttpClient
import com.ioki.passenger.api.internal.Logging
import com.ioki.passenger.api.internal.api.IokiApi
import com.ioki.passenger.api.internal.authorisation.createAuthHeaderProvider
import com.ioki.passenger.api.internal.utils.isConnectivityError
import com.ioki.passenger.api.models.ApiAuthenticatedUserResponse
import com.ioki.passenger.api.models.ApiBody
import com.ioki.passenger.api.models.ApiBookingRequest
import com.ioki.passenger.api.models.ApiBootstrapResponse
import com.ioki.passenger.api.models.ApiCalculateNewFareRequest
import com.ioki.passenger.api.models.ApiCancellationRequest
import com.ioki.passenger.api.models.ApiCancellationVoucherRequest
import com.ioki.passenger.api.models.ApiCancellationVoucherResponse
import com.ioki.passenger.api.models.ApiCaptchaRequest
import com.ioki.passenger.api.models.ApiClientChallengeRequest
import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.models.ApiCreateLogPayPaymentMethodRequest
import com.ioki.passenger.api.models.ApiCreateTipRequest
import com.ioki.passenger.api.models.ApiDeviceRequest
import com.ioki.passenger.api.models.ApiDeviceResponse
import com.ioki.passenger.api.models.ApiDoorStateChangeRequest
import com.ioki.passenger.api.models.ApiErrorBody
import com.ioki.passenger.api.models.ApiFailedPaymentRequest
import com.ioki.passenger.api.models.ApiFailedPaymentResponse
import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest
import com.ioki.passenger.api.models.ApiFirebaseTokenResponse
import com.ioki.passenger.api.models.ApiGeocodingDetailsRequest
import com.ioki.passenger.api.models.ApiGeocodingDetailsResponse
import com.ioki.passenger.api.models.ApiGeocodingSearchRequest
import com.ioki.passenger.api.models.ApiGeocodingSearchResponse
import com.ioki.passenger.api.models.ApiGeocodingSessionRequest
import com.ioki.passenger.api.models.ApiGeocodingSessionResponse
import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiLogPayUrlResponse
import com.ioki.passenger.api.models.ApiMarketingResponse
import com.ioki.passenger.api.models.ApiNotificationResponse
import com.ioki.passenger.api.models.ApiPassengerSelectionRequest
import com.ioki.passenger.api.models.ApiPaymentMethodCreationRequest
import com.ioki.passenger.api.models.ApiPaymentMethodResponse
import com.ioki.passenger.api.models.ApiPaypalClientTokenResponse
import com.ioki.passenger.api.models.ApiPersonalDiscountPurchaseRequest
import com.ioki.passenger.api.models.ApiPersonalDiscountResponse
import com.ioki.passenger.api.models.ApiPersonalDiscountTypeResponse
import com.ioki.passenger.api.models.ApiPhoneVerificationRequest
import com.ioki.passenger.api.models.ApiPhoneVerificationResponse
import com.ioki.passenger.api.models.ApiProviderNotificationSettingsResponse
import com.ioki.passenger.api.models.ApiPurchaseFilter
import com.ioki.passenger.api.models.ApiPurchaseResponse
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest
import com.ioki.passenger.api.models.ApiRatingCriteriaResponse
import com.ioki.passenger.api.models.ApiRatingRequest
import com.ioki.passenger.api.models.ApiRatingResponse
import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest
import com.ioki.passenger.api.models.ApiRedeemReferralCodeRequest
import com.ioki.passenger.api.models.ApiRedeemedPromoCodeResponse
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest
import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiRequestTokenResponse
import com.ioki.passenger.api.models.ApiResettleDebitsRequest
import com.ioki.passenger.api.models.ApiRideFilterType
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import com.ioki.passenger.api.models.ApiRideInquiryResponse
import com.ioki.passenger.api.models.ApiRideRequest
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiRideSeriesRequest
import com.ioki.passenger.api.models.ApiRideSeriesResponse
import com.ioki.passenger.api.models.ApiScheduleResponse
import com.ioki.passenger.api.models.ApiSettleDebitRequest
import com.ioki.passenger.api.models.ApiSignUpRequest
import com.ioki.passenger.api.models.ApiStationResponse
import com.ioki.passenger.api.models.ApiStationsRequest
import com.ioki.passenger.api.models.ApiStripeSetupIntentResponse
import com.ioki.passenger.api.models.ApiTicketingProductFilterType
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import com.ioki.passenger.api.models.ApiTicketingShopConfigurationResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import com.ioki.passenger.api.models.ApiTipResponse
import com.ioki.passenger.api.models.ApiUpdatePassengersForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePaymentMethodForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest
import com.ioki.passenger.api.models.ApiUpdateUserRequest
import com.ioki.passenger.api.models.ApiUserFlagsRequest
import com.ioki.passenger.api.models.ApiUserNotificationSettingsResponse
import com.ioki.passenger.api.models.ApiUserTicketingVouchersFilter
import com.ioki.passenger.api.models.ApiVenueResponse
import com.ioki.passenger.api.result.ApiResult
import com.ioki.passenger.api.result.Error
import com.ioki.passenger.api.result.HttpStatusCode
import com.ioki.passenger.api.result.SuccessData
import com.ioki.result.Result
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlin.coroutines.cancellation.CancellationException
import kotlin.time.Instant

public fun IokiService(
    baseUrl: String,
    requestHeaders: RequestHeaders,
    accessTokenProvider: AccessTokenProvider,
    interceptors: Set<ApiErrorInterceptor> = setOf(),
    timeOffsetProvider: TimeOffsetProvider = NoopTimeOffsetProvider,
    logging: Logging? = null,
    cachingEnabled: Boolean = true,
): IokiService {
    val httpClient = IokiHttpClient(baseUrl, requestHeaders, timeOffsetProvider, logging, cachingEnabled)
    return IokiService(
        accessTokenProvider = accessTokenProvider,
        iokiHttpClient = httpClient,
        interceptors = interceptors,
    )
}

/**
 * Visible 'internal' for testing only.
 * Here, we can inject a custom IokiHttpClient.
 */
internal fun IokiService(
    accessTokenProvider: AccessTokenProvider,
    iokiHttpClient: IokiHttpClient,
    interceptors: Set<ApiErrorInterceptor> = setOf(),
): IokiService = DefaultIokiService(
    iokiApi = IokiApi(iokiHttpClient, createAuthHeaderProvider(accessTokenProvider)),
    interceptors = interceptors,
)

public interface IokiService :
    BootstrapService,
    ClientService,
    PhoneVerificationService,
    FirebaseService,
    UserService,
    MarketingService,
    NotificationService,
    CurrentRideService,
    RideService,
    RideSeriesService,
    TipService,
    GetPaymentService,
    RedeemService,
    LogPayService,
    StripeService,
    PayPalService,
    PaymentService,
    PurchaseService,
    PublicTransportService,
    TicketingService,
    StationsService,
    VenuesService,
    GeocodingService

public interface PhoneVerificationService {
    public suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): ApiResult<Unit>

    public suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): ApiResult<Unit>

    public suspend fun requestPhoneVerification(
        verification: ApiPhoneVerificationRequest,
    ): ApiResult<ApiPhoneVerificationResponse>
}

public interface FirebaseService {
    public suspend fun createDevice(deviceRequest: ApiDeviceRequest): ApiResult<ApiDeviceResponse>

    public suspend fun getFirebaseToken(): ApiResult<ApiFirebaseTokenResponse>

    public suspend fun sendFirebaseDebugRecord(
        debugId: String,
        firebaseDebugRecord: ApiFirebaseDebugRecordRequest,
    ): ApiResult<Unit>
}

public interface UserService {
    public suspend fun requestApiToken(request: ApiRequestTokenRequest): ApiResult<ApiRequestTokenResponse>

    public suspend fun signUp(request: ApiSignUpRequest): ApiResult<ApiAuthenticatedUserResponse>

    public suspend fun getUser(): ApiResult<ApiAuthenticatedUserResponse>

    public suspend fun updateUser(request: ApiUpdateUserRequest): ApiResult<ApiAuthenticatedUserResponse>

    public suspend fun deleteUser(): ApiResult<Unit>

    public suspend fun logoutUser(): ApiResult<Unit>

    public suspend fun updatePhoneNumber(request: ApiUpdatePhoneNumberRequest): ApiResult<ApiAuthenticatedUserResponse>

    public suspend fun updateUserFlags(request: ApiUserFlagsRequest): ApiResult<ApiAuthenticatedUserResponse>

    public suspend fun updateLanguage(): ApiResult<Unit>
}

public interface MarketingService {
    public suspend fun marketingApproval(): ApiResult<ApiMarketingResponse>

    public suspend fun marketingRejection(): ApiResult<ApiMarketingResponse>
}

public interface NotificationService {
    public suspend fun getUserNotificationSettings(): ApiResult<List<ApiUserNotificationSettingsResponse>?>

    public suspend fun getAvailableProviderNotificationSettings(): //
        ApiResult<List<ApiProviderNotificationSettingsResponse>>

    public suspend fun getDefaultProviderNotificationSettings(): //
        ApiResult<List<ApiProviderNotificationSettingsResponse>>

    public suspend fun updateUserNotificationSettings(
        request: ApiUpdateUserNotificationSettingsRequest,
        userId: String,
    ): ApiResult<ApiUserNotificationSettingsResponse>

    public suspend fun getNotification(id: String): ApiResult<ApiNotificationResponse>
}

public interface CurrentRideService {
    public suspend fun getCurrentRide(): ApiResult<ApiRideResponse>

    public suspend fun requestPhoneCall(rideId: String): ApiResult<Unit>

    public suspend fun calculateNewFareForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
    ): ApiResult<ApiFareResponse>

    public suspend fun updatePassengersForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
        rideVersion: Int,
        fareVersion: Int,
        paypalSecureElement: String?,
        requirePaymentMethodForPaidChange: Boolean,
    ): ApiResult<ApiRideResponse>

    public suspend fun updatePaymentMethodForRide(
        rideId: String,
        request: ApiUpdatePaymentMethodForRideRequest,
    ): ApiResult<ApiRideResponse>
}

public interface RideService {
    public suspend fun createRide(request: ApiRideRequest): ApiResult<ApiRideResponse>

    public suspend fun createBooking(rideId: String, request: ApiBookingRequest): ApiResult<Unit>

    public suspend fun cancelRide(
        rideId: String,
        cancellationRequest: ApiCancellationRequest,
    ): ApiResult<ApiRideResponse>

    public suspend fun getCancellationVoucher(
        rideId: String,
        request: ApiCancellationVoucherRequest,
    ): ApiResult<ApiCancellationVoucherResponse>

    public suspend fun getRide(rideId: String): ApiResult<ApiRideResponse>

    public suspend fun getRides(type: ApiRideFilterType, page: Int): ApiResult<List<ApiRideResponse>>

    public suspend fun submitRating(rideId: String, request: ApiRatingRequest): ApiResult<ApiRatingResponse>

    public suspend fun inquireRide(request: ApiRideInquiryRequest): ApiResult<ApiRideInquiryResponse>

    public suspend fun changeDoorState(rideId: String, request: ApiDoorStateChangeRequest): ApiResult<Unit>

    public suspend fun getRatingCriteria(rideId: String): ApiResult<List<ApiRatingCriteriaResponse>>
}

public interface RideSeriesService {
    public suspend fun getRideSeries(rideSeriesId: String): ApiResult<ApiRideSeriesResponse>

    public suspend fun getRideSeriesList(page: Int): ApiResult<List<ApiRideSeriesResponse>>

    public suspend fun createRideSeries(
        rideId: String,
        request: ApiRideSeriesRequest,
    ): ApiResult<ApiRideSeriesResponse>
}

public interface TipService {
    public suspend fun sendTip(rideId: String, request: ApiCreateTipRequest): ApiResult<ApiTipResponse>
}

public interface GetPaymentService {
    public suspend fun getPaymentMethods(): ApiResult<List<ApiPaymentMethodResponse>>

    public suspend fun getServiceCreditPackages(): ApiResult<List<ApiPurchasedCreditPackageResponse>>

    public suspend fun getAvailablePersonalDiscountTypes(): ApiResult<List<ApiPersonalDiscountTypeResponse>>

    public suspend fun getMyPersonalDiscounts(): ApiResult<List<ApiPersonalDiscountResponse>>

    public suspend fun getRedeemedPromoCodes(): ApiResult<List<ApiRedeemedPromoCodeResponse>>
}

public interface LogPayService {
    public suspend fun createLogPayCustomer(request: ApiLogPayAccountRequest): ApiResult<ApiLogPayUrlResponse>

    public suspend fun getLogPayUrl(paymentMethodType: ApiLogPayType): ApiResult<ApiLogPayUrlResponse>
}

public interface StripeService {
    public suspend fun requestStripeSetupIntent(): ApiResult<ApiStripeSetupIntentResponse>

    public suspend fun createPaymentMethodFromStripePaymentMethod(
        stripePaymentMethodId: String,
    ): ApiResult<ApiPaymentMethodResponse>
}

public interface PayPalService {
    public suspend fun createPaymentMethodForPaypal(
        braintreeNonce: String,
        paypalSecureElement: String,
    ): ApiResult<ApiPaymentMethodResponse>

    public suspend fun createPaypalClientToken(): ApiResult<ApiPaypalClientTokenResponse>
}

public interface PaymentService {
    public suspend fun detachPaymentMethod(paymentMethodId: String): ApiResult<Unit>

    public suspend fun purchaseCreditPackage(
        purchasingPackage: ApiPurchasingCreditPackageRequest,
    ): ApiResult<ApiPurchasedCreditPackageResponse>

    public suspend fun purchasePersonalDiscount(
        purchaseRequest: ApiPersonalDiscountPurchaseRequest,
    ): ApiResult<ApiPersonalDiscountResponse>

    public suspend fun payFailedPayments(request: ApiFailedPaymentRequest): ApiResult<ApiFailedPaymentResponse>
}

public interface RedeemService {
    public suspend fun redeemPromoCode(request: ApiRedeemPromoCodeRequest): ApiResult<ApiRedeemedPromoCodeResponse>

    public suspend fun redeemReferralCode(code: String): ApiResult<Unit>
}

public interface PublicTransportService {
    public suspend fun getPublicTransportSchedules(url: String, time: Instant): ApiResult<List<ApiScheduleResponse>>
}

public interface TicketingService {
    public suspend fun getShopConfiguration(): ApiResult<ApiTicketingShopConfigurationResponse>

    public suspend fun getUserTicketingVouchers(
        page: Int,
        filter: ApiUserTicketingVouchersFilter,
    ): ApiResult<List<ApiTicketingVoucherResponse>>

    public suspend fun getUserTicketingVoucher(ticketVoucherId: String): ApiResult<ApiTicketingVoucherResponse>

    public suspend fun getAllTicketingProducts(
        type: ApiTicketingProductFilterType,
        rideId: String?,
        ticketFilter: Map<String, String>,
        page: Int,
    ): ApiResult<List<ApiTicketingProductResponse>>

    public suspend fun orderTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): ApiResult<ApiTicketingVoucherResponse>

    public suspend fun preorderTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): ApiResult<ApiTicketingVoucherResponse>

    public suspend fun renewTicketingVoucher(
        id: String,
        request: ApiRenewTicketingVoucherRequest,
    ): ApiResult<ApiTicketingVoucherResponse>

    public suspend fun cancelTicketingVoucher(voucherId: String): ApiResult<ApiTicketingVoucherResponse>
}

public interface BootstrapService {
    public suspend fun getBootstrap(): ApiResult<ApiBootstrapResponse>
}

public interface ClientService {
    public suspend fun requestClientInfo(): ApiResult<ApiClientInfoResponse>
}

public interface StationsService {
    public suspend fun getStations(request: ApiStationsRequest): ApiResult<List<ApiStationResponse>>
}

public interface VenuesService {
    public suspend fun getVenues(): ApiResult<List<ApiVenueResponse>>
}

public interface PurchaseService {
    public suspend fun getPurchases(filter: ApiPurchaseFilter): ApiResult<List<ApiPurchaseResponse>>
    public suspend fun getPurchase(purchaseId: String): ApiResult<ApiPurchaseResponse>
    public suspend fun settleDebit(purchaseId: String, request: ApiSettleDebitRequest): ApiResult<ApiPurchaseResponse>
    public suspend fun resettleDebits(request: ApiResettleDebitsRequest): ApiResult<List<ApiPurchaseResponse>>
}

public interface GeocodingService {
    public suspend fun getGeocodingSession(request: ApiGeocodingSessionRequest): ApiResult<ApiGeocodingSessionResponse>
    public suspend fun expireGeocodingSession(sessionId: String): ApiResult<Unit>
    public suspend fun getGeocodingSearch(
        sessionId: String,
        request: ApiGeocodingSearchRequest,
    ): ApiResult<ApiGeocodingSearchResponse>

    public suspend fun getGeocodingDetails(
        sessionId: String,
        request: ApiGeocodingDetailsRequest,
    ): ApiResult<ApiGeocodingDetailsResponse>
}

private class DefaultIokiService(private val iokiApi: IokiApi, private val interceptors: Set<ApiErrorInterceptor>) :
    IokiService {
    override suspend fun requestPhoneVerification(
        verification: ApiPhoneVerificationRequest,
    ): ApiResult<ApiPhoneVerificationResponse> =
        apiCall<ApiBody<ApiPhoneVerificationResponse>, ApiPhoneVerificationResponse> {
            requestPhoneVerification(ApiBody(verification))
        }

    override suspend fun requestApiToken(request: ApiRequestTokenRequest): ApiResult<ApiRequestTokenResponse> =
        apiCall<ApiBody<ApiRequestTokenResponse>, ApiRequestTokenResponse> {
            requestApiToken(ApiBody(request))
        }

    override suspend fun signUp(request: ApiSignUpRequest): ApiResult<ApiAuthenticatedUserResponse> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            signUp(body = ApiBody(request))
        }

    override suspend fun createRide(request: ApiRideRequest): ApiResult<ApiRideResponse> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
            createRide(body = ApiBody(request))
        }

    override suspend fun cancelRide(
        rideId: String,
        cancellationRequest: ApiCancellationRequest,
    ): ApiResult<ApiRideResponse> = apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
        cancelRide(rideId = rideId, body = ApiBody(cancellationRequest))
    }

    override suspend fun getCancellationVoucher(
        rideId: String,
        request: ApiCancellationVoucherRequest,
    ): ApiResult<ApiCancellationVoucherResponse> =
        apiCall<ApiBody<ApiCancellationVoucherResponse>, ApiCancellationVoucherResponse> {
            getCancellationVoucher(rideId = rideId, body = ApiBody(request))
        }

    override suspend fun getRide(rideId: String): ApiResult<ApiRideResponse> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
            getRide(rideId = rideId)
        }

    override suspend fun getCurrentRide(): ApiResult<ApiRideResponse> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
            getCurrentRide()
        }

    override suspend fun requestPhoneCall(rideId: String): ApiResult<Unit> = apiCall<Unit, Unit> {
        requestPhoneCall(rideId = rideId)
    }

    override suspend fun getRides(type: ApiRideFilterType, page: Int): ApiResult<List<ApiRideResponse>> =
        apiCall<ApiBody<List<ApiRideResponse>>, List<ApiRideResponse>> {
            getRides(type = type.queryValue, page = page)
        }

    override suspend fun getRideSeries(rideSeriesId: String): ApiResult<ApiRideSeriesResponse> =
        apiCall<ApiBody<ApiRideSeriesResponse>, ApiRideSeriesResponse> {
            getRideSeries(rideSeriesId = rideSeriesId)
        }

    override suspend fun getRideSeriesList(page: Int): ApiResult<List<ApiRideSeriesResponse>> =
        apiCall<ApiBody<List<ApiRideSeriesResponse>>, List<ApiRideSeriesResponse>> {
            getRideSeriesList(page = page)
        }

    override suspend fun createRideSeries(
        rideId: String,
        request: ApiRideSeriesRequest,
    ): ApiResult<ApiRideSeriesResponse> = apiCall<ApiBody<ApiRideSeriesResponse>, ApiRideSeriesResponse> {
        createRideSeries(rideId = rideId, body = ApiBody(request))
    }

    override suspend fun submitRating(rideId: String, request: ApiRatingRequest): ApiResult<ApiRatingResponse> =
        apiCall<ApiBody<ApiRatingResponse>, ApiRatingResponse> {
            submitRating(rideId = rideId, body = ApiBody(request))
        }

    override suspend fun getPublicTransportSchedules(
        url: String,
        time: Instant,
    ): ApiResult<List<ApiScheduleResponse>> = apiCall<ApiBody<List<ApiScheduleResponse>>, List<ApiScheduleResponse>> {
        requestPublicTransportSchedules(url = url, time = time)
    }

    override suspend fun getShopConfiguration(): ApiResult<ApiTicketingShopConfigurationResponse> =
        apiCall<ApiBody<ApiTicketingShopConfigurationResponse>, ApiTicketingShopConfigurationResponse> {
            getTicketShopConfiguration()
        }

    override suspend fun getUserTicketingVouchers(
        page: Int,
        filter: ApiUserTicketingVouchersFilter,
    ): ApiResult<List<ApiTicketingVoucherResponse>> =
        apiCall<ApiBody<List<ApiTicketingVoucherResponse>>, List<ApiTicketingVoucherResponse>> {
            getUserTicketingVouchers(page = page, filter = filter)
        }

    override suspend fun calculateNewFareForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
    ): ApiResult<ApiFareResponse> = apiCall<ApiBody<ApiFareResponse>, ApiFareResponse> {
        calculateNewFareForRide(rideId = rideId, body = ApiBody(ApiCalculateNewFareRequest(passengers)))
    }

    override suspend fun updatePassengersForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
        rideVersion: Int,
        fareVersion: Int,
        paypalSecureElement: String?,
        requirePaymentMethodForPaidChange: Boolean,
    ): ApiResult<ApiRideResponse> = apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
        val body = ApiBody(
            ApiUpdatePassengersForRideRequest(
                passengers,
                rideVersion,
                fareVersion,
                paypalSecureElement,
                requirePaymentMethodForPaidChange,
            ),
        )
        updatePassengersForRide(rideId = rideId, body = body)
    }

    override suspend fun updatePaymentMethodForRide(
        rideId: String,
        request: ApiUpdatePaymentMethodForRideRequest,
    ): ApiResult<ApiRideResponse> = apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
        updatePaymentMethodForRide(rideId = rideId, body = ApiBody(request))
    }

    override suspend fun sendTip(rideId: String, request: ApiCreateTipRequest): ApiResult<ApiTipResponse> =
        apiCall<ApiBody<ApiTipResponse>, ApiTipResponse> {
            sendTip(rideId = rideId, body = ApiBody(request))
        }

    override suspend fun changeDoorState(rideId: String, request: ApiDoorStateChangeRequest): ApiResult<Unit> =
        apiCall<Unit, Unit> {
            changeDoorState(rideId = rideId, body = ApiBody(request))
        }

    override suspend fun inquireRide(request: ApiRideInquiryRequest): ApiResult<ApiRideInquiryResponse> =
        apiCall<ApiBody<ApiRideInquiryResponse>, ApiRideInquiryResponse> {
            inquireRide(body = ApiBody(request))
        }

    override suspend fun getServiceCreditPackages(): ApiResult<List<ApiPurchasedCreditPackageResponse>> =
        apiCall<ApiBody<List<ApiPurchasedCreditPackageResponse>>, List<ApiPurchasedCreditPackageResponse>> {
            getServiceCreditPackages()
        }

    override suspend fun getVenues(): ApiResult<List<ApiVenueResponse>> =
        apiCall<ApiBody<List<ApiVenueResponse>>, List<ApiVenueResponse>> {
            getVenues()
        }

    override suspend fun getUserNotificationSettings(): ApiResult<List<ApiUserNotificationSettingsResponse>?> =
        apiCall<ApiBody<List<ApiUserNotificationSettingsResponse>?>, List<ApiUserNotificationSettingsResponse>?> {
            getUserNotificationSettings()
        }

    @Suppress("ktlint:standard:max-line-length")
    override suspend fun getAvailableProviderNotificationSettings(): ApiResult<List<ApiProviderNotificationSettingsResponse>> =
        apiCall<ApiBody<List<ApiProviderNotificationSettingsResponse>>, List<ApiProviderNotificationSettingsResponse>> {
            getAvailableProviderNotificationSettings()
        }

    @Suppress("ktlint:standard:max-line-length")
    override suspend fun getDefaultProviderNotificationSettings(): ApiResult<List<ApiProviderNotificationSettingsResponse>> =
        apiCall<ApiBody<List<ApiProviderNotificationSettingsResponse>>, List<ApiProviderNotificationSettingsResponse>> {
            getDefaultProviderNotificationSettings()
        }

    override suspend fun updateUserNotificationSettings(
        request: ApiUpdateUserNotificationSettingsRequest,
        userId: String,
    ): ApiResult<ApiUserNotificationSettingsResponse> =
        apiCall<ApiBody<ApiUserNotificationSettingsResponse>, ApiUserNotificationSettingsResponse> {
            updateUserNotificationSettings(userId = userId, body = ApiBody(request))
        }

    override suspend fun sendFirebaseDebugRecord(
        debugId: String,
        firebaseDebugRecord: ApiFirebaseDebugRecordRequest,
    ): ApiResult<Unit> = apiCall<Unit, Unit> {
        sendFirebaseDebugRecord(id = debugId, body = ApiBody(firebaseDebugRecord))
    }

    override suspend fun getBootstrap(): ApiResult<ApiBootstrapResponse> =
        apiCall<ApiBody<ApiBootstrapResponse>, ApiBootstrapResponse> {
            getBootstrap()
        }

    override suspend fun getUser(): ApiResult<ApiAuthenticatedUserResponse> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            getUser()
        }

    override suspend fun updateUser(request: ApiUpdateUserRequest): ApiResult<ApiAuthenticatedUserResponse> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updateUser(body = ApiBody(request))
        }

    override suspend fun createDevice(deviceRequest: ApiDeviceRequest): ApiResult<ApiDeviceResponse> =
        apiCall<ApiBody<ApiDeviceResponse>, ApiDeviceResponse> {
            createDevice(body = ApiBody(deviceRequest))
        }

    override suspend fun getFirebaseToken(): ApiResult<ApiFirebaseTokenResponse> =
        apiCall<ApiBody<ApiFirebaseTokenResponse>, ApiFirebaseTokenResponse> {
            getFirebaseToken()
        }

    override suspend fun marketingApproval(): ApiResult<ApiMarketingResponse> =
        apiCall<ApiBody<ApiMarketingResponse>, ApiMarketingResponse> { marketingApproval() }

    override suspend fun marketingRejection(): ApiResult<ApiMarketingResponse> =
        apiCall<ApiBody<ApiMarketingResponse>, ApiMarketingResponse> {
            marketingRejection()
        }

    override suspend fun deleteUser(): ApiResult<Unit> = apiCall<Unit, Unit> {
        deleteUser()
    }

    override suspend fun logoutUser(): ApiResult<Unit> = apiCall<Unit, Unit> {
        logoutUser()
    }

    override suspend fun updatePhoneNumber(
        request: ApiUpdatePhoneNumberRequest,
    ): ApiResult<ApiAuthenticatedUserResponse> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updatePhoneNumber(body = ApiBody(request))
        }

    override suspend fun createLogPayCustomer(request: ApiLogPayAccountRequest): ApiResult<ApiLogPayUrlResponse> =
        apiCall<ApiBody<ApiLogPayUrlResponse>, ApiLogPayUrlResponse> {
            createLogPayCustomer(body = ApiBody(request))
        }

    override suspend fun getLogPayUrl(paymentMethodType: ApiLogPayType): ApiResult<ApiLogPayUrlResponse> =
        apiCall<ApiBody<ApiLogPayUrlResponse>, ApiLogPayUrlResponse> {
            getLogPayUrl(body = ApiBody(ApiCreateLogPayPaymentMethodRequest(paymentMethodType)))
        }

    override suspend fun updateUserFlags(request: ApiUserFlagsRequest): ApiResult<ApiAuthenticatedUserResponse> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updateUserFlags(body = ApiBody(request))
        }

    override suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): ApiResult<Unit> =
        apiCall<Unit, Unit> {
            solveCaptcha(id = captchaId, body = ApiBody(captchaRequest))
        }

    override suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): ApiResult<Unit> =
        apiCall<Unit, Unit> {
            solveClientChallenge(id = id, body = ApiBody(request))
        }

    override suspend fun createBooking(rideId: String, request: ApiBookingRequest): ApiResult<Unit> =
        apiCall<Unit, Unit> {
            createBooking(rideId = rideId, body = ApiBody(request))
        }

    override suspend fun updateLanguage(): ApiResult<Unit> = apiCall<Unit, Unit> {
        updateLanguage()
    }

    override suspend fun requestClientInfo(): ApiResult<ApiClientInfoResponse> =
        apiCall<ApiBody<ApiClientInfoResponse>, ApiClientInfoResponse> {
            getClient()
        }

    override suspend fun getStations(request: ApiStationsRequest): ApiResult<List<ApiStationResponse>> =
        apiCall<ApiBody<List<ApiStationResponse>>, List<ApiStationResponse>> {
            getStations(
                query = request.query,
                productId = request.productId,
                xmin = request.xmin,
                xmax = request.xmax,
                ymin = request.ymin,
                ymax = request.ymax,
            )
        }

    override suspend fun detachPaymentMethod(paymentMethodId: String): ApiResult<Unit> = apiCall<Unit, Unit> {
        detachPaymentMethod(paymentMethodId = paymentMethodId)
    }

    override suspend fun getRedeemedPromoCodes(): ApiResult<List<ApiRedeemedPromoCodeResponse>> =
        apiCall<ApiBody<List<ApiRedeemedPromoCodeResponse>>, List<ApiRedeemedPromoCodeResponse>> {
            getRedeemedPromoCodes()
        }

    override suspend fun purchaseCreditPackage(
        purchasingPackage: ApiPurchasingCreditPackageRequest,
    ): ApiResult<ApiPurchasedCreditPackageResponse> =
        apiCall<ApiBody<ApiPurchasedCreditPackageResponse>, ApiPurchasedCreditPackageResponse> {
            purchaseCreditPackage(body = ApiBody(purchasingPackage))
        }

    override suspend fun getAvailablePersonalDiscountTypes(): ApiResult<List<ApiPersonalDiscountTypeResponse>> =
        apiCall<ApiBody<List<ApiPersonalDiscountTypeResponse>>, List<ApiPersonalDiscountTypeResponse>> {
            getAvailablePersonalDiscountTypes()
        }

    override suspend fun getMyPersonalDiscounts(): ApiResult<List<ApiPersonalDiscountResponse>> =
        apiCall<ApiBody<List<ApiPersonalDiscountResponse>>, List<ApiPersonalDiscountResponse>> {
            getMyPersonalDiscounts()
        }

    override suspend fun purchasePersonalDiscount(
        purchaseRequest: ApiPersonalDiscountPurchaseRequest,
    ): ApiResult<ApiPersonalDiscountResponse> =
        apiCall<ApiBody<ApiPersonalDiscountResponse>, ApiPersonalDiscountResponse> {
            purchasePersonalDiscount(body = ApiBody(purchaseRequest))
        }

    override suspend fun redeemPromoCode(request: ApiRedeemPromoCodeRequest): ApiResult<ApiRedeemedPromoCodeResponse> =
        apiCall<ApiBody<ApiRedeemedPromoCodeResponse>, ApiRedeemedPromoCodeResponse> {
            redeemPromoCode(body = ApiBody(request))
        }

    override suspend fun requestStripeSetupIntent(): ApiResult<ApiStripeSetupIntentResponse> =
        apiCall<ApiBody<ApiStripeSetupIntentResponse>, ApiStripeSetupIntentResponse> {
            requestStripeSetupIntent()
        }

    override suspend fun createPaymentMethodFromStripePaymentMethod(
        stripePaymentMethodId: String,
    ): ApiResult<ApiPaymentMethodResponse> = apiCall<ApiBody<ApiPaymentMethodResponse>, ApiPaymentMethodResponse> {
        val data = ApiPaymentMethodCreationRequest(
            "stripe",
            ApiPaymentMethodCreationRequest.Details(
                stripePaymentMethodId = stripePaymentMethodId,
                null,
                null,
            ),
        )
        createPaymentMethod(body = ApiBody(data))
    }

    override suspend fun createPaymentMethodForPaypal(
        braintreeNonce: String,
        paypalSecureElement: String,
    ): ApiResult<ApiPaymentMethodResponse> = apiCall<ApiBody<ApiPaymentMethodResponse>, ApiPaymentMethodResponse> {
        val data = ApiPaymentMethodCreationRequest(
            "logpay",
            ApiPaymentMethodCreationRequest.Details(
                braintreeNonce = braintreeNonce,
                paypalSecureElement = paypalSecureElement,
                stripePaymentMethodId = null,
            ),
        )
        createPaymentMethod(body = ApiBody(data))
    }

    override suspend fun getPaymentMethods(): ApiResult<List<ApiPaymentMethodResponse>> =
        apiCall<ApiBody<List<ApiPaymentMethodResponse>>, List<ApiPaymentMethodResponse>> {
            getPaymentMethods()
        }

    override suspend fun redeemReferralCode(code: String): ApiResult<Unit> = apiCall<Unit, Unit> {
        redeemReferralCode(body = ApiBody(ApiRedeemReferralCodeRequest(code)))
    }

    override suspend fun createPaypalClientToken(): ApiResult<ApiPaypalClientTokenResponse> =
        apiCall<ApiBody<ApiPaypalClientTokenResponse>, ApiPaypalClientTokenResponse> {
            createPaypalClientToken()
        }

    override suspend fun payFailedPayments(request: ApiFailedPaymentRequest): ApiResult<ApiFailedPaymentResponse> =
        apiCall<ApiBody<ApiFailedPaymentResponse>, ApiFailedPaymentResponse> {
            payFailedPayments(body = ApiBody(request))
        }

    override suspend fun getPurchases(filter: ApiPurchaseFilter): ApiResult<List<ApiPurchaseResponse>> =
        apiCall<ApiBody<List<ApiPurchaseResponse>>, List<ApiPurchaseResponse>> { getPurchases(filter) }

    override suspend fun getPurchase(purchaseId: String): ApiResult<ApiPurchaseResponse> =
        apiCall<ApiBody<ApiPurchaseResponse>, ApiPurchaseResponse> { getPurchase(id = purchaseId) }

    override suspend fun settleDebit(
        purchaseId: String,
        request: ApiSettleDebitRequest,
    ): ApiResult<ApiPurchaseResponse> = apiCall<ApiBody<ApiPurchaseResponse>, ApiPurchaseResponse> {
        settleDebit(purchaseId = purchaseId, body = ApiBody(request))
    }

    override suspend fun resettleDebits(request: ApiResettleDebitsRequest): ApiResult<List<ApiPurchaseResponse>> =
        apiCall<ApiBody<List<ApiPurchaseResponse>>, List<ApiPurchaseResponse>> {
            resettleDebits(body = ApiBody(request))
        }

    override suspend fun getAllTicketingProducts(
        type: ApiTicketingProductFilterType,
        rideId: String?,
        ticketFilter: Map<String, String>,
        page: Int,
    ): ApiResult<List<ApiTicketingProductResponse>> =
        apiCall<ApiBody<List<ApiTicketingProductResponse>>, List<ApiTicketingProductResponse>> {
            getAllTicketingProducts(filter = type.queryValue, ticketFilter = ticketFilter, rideId = rideId, page = page)
        }

    override suspend fun orderTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): ApiResult<ApiTicketingVoucherResponse> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            orderTicketingProduct(id = id, body = ApiBody(request))
        }

    override suspend fun preorderTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): ApiResult<ApiTicketingVoucherResponse> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            preorderTicketingProduct(id = id, body = ApiBody(request))
        }

    override suspend fun renewTicketingVoucher(
        id: String,
        request: ApiRenewTicketingVoucherRequest,
    ): ApiResult<ApiTicketingVoucherResponse> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            renewUserTicketingVoucher(id = id, body = ApiBody(request))
        }

    override suspend fun cancelTicketingVoucher(voucherId: String): ApiResult<ApiTicketingVoucherResponse> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            cancelUserTicketingVoucher(id = voucherId)
        }

    override suspend fun getUserTicketingVoucher(ticketVoucherId: String): ApiResult<ApiTicketingVoucherResponse> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            getUserTicketingVoucher(id = ticketVoucherId)
        }

    override suspend fun getRatingCriteria(rideId: String): ApiResult<List<ApiRatingCriteriaResponse>> =
        apiCall<ApiBody<List<ApiRatingCriteriaResponse>>, List<ApiRatingCriteriaResponse>> {
            getRatingCriteria(rideId = rideId)
        }

    override suspend fun getGeocodingSession(
        request: ApiGeocodingSessionRequest,
    ): ApiResult<ApiGeocodingSessionResponse> =
        apiCall<ApiBody<ApiGeocodingSessionResponse>, ApiGeocodingSessionResponse> {
            geocodingSession(body = ApiBody(request))
        }

    override suspend fun expireGeocodingSession(sessionId: String): ApiResult<Unit> = apiCall<Unit, Unit> {
        expireGeocodingSession(id = sessionId)
    }

    override suspend fun getGeocodingSearch(
        sessionId: String,
        request: ApiGeocodingSearchRequest,
    ): ApiResult<ApiGeocodingSearchResponse> =
        apiCall<ApiBody<ApiGeocodingSearchResponse>, ApiGeocodingSearchResponse> {
            geocodingSearch(id = sessionId, body = ApiBody(request))
        }

    override suspend fun getGeocodingDetails(
        sessionId: String,
        request: ApiGeocodingDetailsRequest,
    ): ApiResult<ApiGeocodingDetailsResponse> =
        apiCall<ApiBody<ApiGeocodingDetailsResponse>, ApiGeocodingDetailsResponse> {
            geocodingDetails(id = sessionId, body = ApiBody(request))
        }

    override suspend fun getNotification(id: String): ApiResult<ApiNotificationResponse> =
        apiCall<ApiBody<ApiNotificationResponse>, ApiNotificationResponse> {
            getNotification(id)
        }

    private suspend inline fun <reified R, reified T> apiCall(
        crossinline block: suspend IokiApi.() -> HttpResponse,
    ): ApiResult<T> = try {
        val response = iokiApi.block()
        if (response.status.isSuccess()) {
            mapSuccess<R, T>(response)
        } else {
            mapApiError(response, interceptors)
        }
    } catch (e: Exception) {
        when {
            e is CancellationException -> throw e
            e.isConnectivityError -> Result.Failure(Error.Connectivity(e))
            else -> Result.Failure(Error.Generic(e))
        }
    }
}

@Suppress("UNCHECKED_CAST")
internal suspend inline fun <reified R, reified T> mapSuccess(
    successfulResponse: HttpResponse,
): Result.Success<SuccessData<T>> {
    val body = successfulResponse.body<R>()
    val meta = (body as? ApiBody<*>)?.meta
    val data = when (body) {
        null -> Unit as? T // For Void (no content) body
        is T -> body
        is ApiBody<*> ->
            when {
                body.data is T -> body.data
                T::class == String::class -> body.data.toString()
                else -> null
            }

        else -> null
    } ?: throw IllegalArgumentException("Failed to convert body '$body' to type ${T::class}")
    return Result.Success(SuccessData(data, meta)) as Result.Success<SuccessData<T>>
}

internal suspend fun mapApiError(
    failedResponse: HttpResponse,
    interceptors: Collection<ApiErrorInterceptor>,
): Result.Failure<Error.Api> {
    val apiErrorBody = failedResponse.body<ApiErrorBody?>()
    val code = failedResponse.status.value
    // 502 happens when Google runs internal tests. Catching it here prevents it from being reported as an error
    val apiErrors = if (code == HttpStatusCode.BAD_GATEWAY_502) emptyList() else apiErrorBody?.apiErrors ?: emptyList()

    interceptors.forEach { interceptor ->
        if (interceptor.intercept(apiErrors, code)) {
            return Result.Failure(Error.Api.Intercepted(apiErrors, code))
        }
    }

    return Result.Failure(Error.Api.Generic(apiErrors, code))
}
