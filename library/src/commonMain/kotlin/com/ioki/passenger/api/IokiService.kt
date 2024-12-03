package com.ioki.passenger.api

import com.ioki.passenger.api.internal.IokiHttpClient
import com.ioki.passenger.api.internal.Logging
import com.ioki.passenger.api.internal.api.IokiApi
import com.ioki.passenger.api.internal.authorisation.AuthHeaderProvider
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
import com.ioki.passenger.api.models.ApiErrorBody
import com.ioki.passenger.api.models.ApiFailedPaymentRequest
import com.ioki.passenger.api.models.ApiFailedPaymentResponse
import com.ioki.passenger.api.models.ApiFareResponse
import com.ioki.passenger.api.models.ApiFirebaseDebugRecordRequest
import com.ioki.passenger.api.models.ApiFirebaseTokenResponse
import com.ioki.passenger.api.models.ApiLogPayAccountRequest
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiLogPayUrlResponse
import com.ioki.passenger.api.models.ApiMarketingResponse
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
import com.ioki.passenger.api.models.ApiPurchaseTicketingProductRequest
import com.ioki.passenger.api.models.ApiPurchasedCreditPackageResponse
import com.ioki.passenger.api.models.ApiPurchasingCreditPackageRequest
import com.ioki.passenger.api.models.ApiRatingRequest
import com.ioki.passenger.api.models.ApiRatingResponse
import com.ioki.passenger.api.models.ApiRedeemPromoCodeRequest
import com.ioki.passenger.api.models.ApiRedeemReferralCodeRequest
import com.ioki.passenger.api.models.ApiRedeemedPromoCodeResponse
import com.ioki.passenger.api.models.ApiRenewTicketingVoucherRequest
import com.ioki.passenger.api.models.ApiRequestTokenRequest
import com.ioki.passenger.api.models.ApiRequestTokenResponse
import com.ioki.passenger.api.models.ApiRideFilterType
import com.ioki.passenger.api.models.ApiRideInquiryRequest
import com.ioki.passenger.api.models.ApiRideInquiryResponse
import com.ioki.passenger.api.models.ApiRideRequest
import com.ioki.passenger.api.models.ApiRideResponse
import com.ioki.passenger.api.models.ApiRideSeriesRequest
import com.ioki.passenger.api.models.ApiRideSeriesResponse
import com.ioki.passenger.api.models.ApiScheduleResponse
import com.ioki.passenger.api.models.ApiSignUpRequest
import com.ioki.passenger.api.models.ApiStationResponse
import com.ioki.passenger.api.models.ApiStationsRequest
import com.ioki.passenger.api.models.ApiStripeSetupIntentResponse
import com.ioki.passenger.api.models.ApiTicketingProductFilterType
import com.ioki.passenger.api.models.ApiTicketingProductResponse
import com.ioki.passenger.api.models.ApiTicketingVoucherResponse
import com.ioki.passenger.api.models.ApiTipResponse
import com.ioki.passenger.api.models.ApiUpdatePassengersForRideRequest
import com.ioki.passenger.api.models.ApiUpdatePhoneNumberRequest
import com.ioki.passenger.api.models.ApiUpdateUserNotificationSettingsRequest
import com.ioki.passenger.api.models.ApiUpdateUserRequest
import com.ioki.passenger.api.models.ApiUserFlagsRequest
import com.ioki.passenger.api.models.ApiUserNotificationSettingsResponse
import com.ioki.passenger.api.models.ApiVenueResponse
import com.ioki.passenger.api.result.Error
import com.ioki.passenger.api.result.HttpStatusCode
import com.ioki.passenger.api.result.SuccessData
import com.ioki.result.Result
import com.ioki.result.map
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.datetime.Instant
import kotlin.coroutines.cancellation.CancellationException

public fun IokiService(
    baseUrl: String,
    requestHeaders: RequestHeaders,
    accessTokenProvider: AccessTokenProvider,
    interceptors: Set<ApiErrorInterceptor> = setOf(),
    timeOffsetProvider: TimeOffsetProvider = NoopTimeOffsetProvider,
    logging: Logging? = null,
): IokiService {
    val httpClient = IokiHttpClient(baseUrl, requestHeaders, timeOffsetProvider, logging)
    val authHeaderProvider = createAuthHeaderProvider(accessTokenProvider)
    val iokiApi = IokiApi(httpClient)
    return DefaultIokiService(iokiApi, authHeaderProvider, interceptors)
}

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
    PublicTransportService,
    TicketingService,
    StationsService,
    VenuesService

public interface PhoneVerificationService {
    public suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): Result<Unit, Error>

    public suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): Result<Unit, Error>

    public suspend fun requestPhoneVerification(
        verification: ApiPhoneVerificationRequest,
    ): Result<ApiPhoneVerificationResponse, Error>
}

public interface FirebaseService {
    public suspend fun createDevice(deviceRequest: ApiDeviceRequest): Result<ApiDeviceResponse, Error>

    public suspend fun getFirebaseToken(): Result<ApiFirebaseTokenResponse, Error>

    public suspend fun sendFirebaseDebugRecord(
        debugId: String,
        firebaseDebugRecord: ApiFirebaseDebugRecordRequest,
    ): Result<Unit, Error>
}

public interface UserService {
    public suspend fun requestApiToken(request: ApiRequestTokenRequest): Result<ApiRequestTokenResponse, Error>

    public suspend fun signUp(request: ApiSignUpRequest): Result<ApiAuthenticatedUserResponse, Error>

    public suspend fun getUser(): Result<ApiAuthenticatedUserResponse, Error>

    public suspend fun updateUser(request: ApiUpdateUserRequest): Result<ApiAuthenticatedUserResponse, Error>

    public suspend fun deleteUser(): Result<Unit, Error>

    public suspend fun updatePhoneNumber(request: ApiUpdatePhoneNumberRequest): Result<ApiAuthenticatedUserResponse, Error>

    public suspend fun updateUserFlags(request: ApiUserFlagsRequest): Result<ApiAuthenticatedUserResponse, Error>

    public suspend fun updateLanguage(): Result<Unit, Error>
}

public interface MarketingService {
    public suspend fun marketingApproval(): Result<ApiMarketingResponse, Error>

    public suspend fun marketingRejection(): Result<ApiMarketingResponse, Error>
}

public interface NotificationService {
    public suspend fun getUserNotificationSettings(): Result<List<ApiUserNotificationSettingsResponse>?, Error>

    public suspend fun getAvailableProviderNotificationSettings(): Result<List<ApiProviderNotificationSettingsResponse>, Error>

    public suspend fun getDefaultProviderNotificationSettings(): Result<List<ApiProviderNotificationSettingsResponse>, Error>

    public suspend fun updateUserNotificationSettings(
        request: ApiUpdateUserNotificationSettingsRequest,
        userId: String,
    ): Result<ApiUserNotificationSettingsResponse, Error>
}

public interface CurrentRideService {
    public suspend fun getCurrentRide(): Result<ApiRideResponse, Error>

    public suspend fun requestPhoneCall(rideId: String): Result<Unit, Error>

    public suspend fun calculateNewFareForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
    ): Result<ApiFareResponse, Error>

    public suspend fun updatePassengersForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
        rideVersion: Int,
        fareVersion: Int,
        paypalSecureElement: String?,
    ): Result<ApiRideResponse, Error>
}

public interface RideService {
    public suspend fun createRide(request: ApiRideRequest): Result<ApiRideResponse, Error>

    public suspend fun createBooking(rideId: String, request: ApiBookingRequest): Result<Unit, Error>

    public suspend fun cancelRide(
        rideId: String,
        cancellationRequest: ApiCancellationRequest,
    ): Result<ApiRideResponse, Error>

    public suspend fun getCancellationVoucher(
        rideId: String,
        request: ApiCancellationVoucherRequest,
    ): Result<ApiCancellationVoucherResponse, Error>

    public suspend fun getRide(rideId: String): Result<ApiRideResponse, Error>

    public suspend fun getRides(type: ApiRideFilterType, page: Int): Result<List<ApiRideResponse>, Error>

    public suspend fun submitRating(rideId: String, request: ApiRatingRequest): Result<ApiRatingResponse, Error>

    public suspend fun inquireRide(request: ApiRideInquiryRequest): Result<ApiRideInquiryResponse, Error>
}

public interface RideSeriesService {
    public suspend fun getRideSeries(rideSeriesId: String): Result<ApiRideSeriesResponse, Error>

    public suspend fun getRideSeriesList(page: Int): Result<List<ApiRideSeriesResponse>, Error>

    public suspend fun createRideSeries(
        rideId: String,
        request: ApiRideSeriesRequest,
    ): Result<ApiRideSeriesResponse, Error>
}

public interface TipService {
    public suspend fun sendTip(rideId: String, request: ApiCreateTipRequest): Result<ApiTipResponse, Error>
}

public interface GetPaymentService {
    public suspend fun getPaymentMethods(): Result<List<ApiPaymentMethodResponse>, Error>

    public suspend fun getServiceCreditPackages(): Result<List<ApiPurchasedCreditPackageResponse>, Error>

    public suspend fun getAvailablePersonalDiscountTypes(): Result<List<ApiPersonalDiscountTypeResponse>, Error>

    public suspend fun getMyPersonalDiscounts(): Result<List<ApiPersonalDiscountResponse>, Error>

    public suspend fun getRedeemedPromoCodes(): Result<List<ApiRedeemedPromoCodeResponse>, Error>
}

public interface LogPayService {
    public suspend fun createLogPayCustomer(request: ApiLogPayAccountRequest): Result<ApiLogPayUrlResponse, Error>

    public suspend fun getLogPayUrl(paymentMethodType: ApiLogPayType): Result<ApiLogPayUrlResponse, Error>
}

public interface StripeService {
    public suspend fun requestStripeSetupIntent(): Result<ApiStripeSetupIntentResponse, Error>

    public suspend fun createPaymentMethodFromStripePaymentMethod(
        stripePaymentMethodId: String,
    ): Result<ApiPaymentMethodResponse, Error>
}

public interface PayPalService {
    public suspend fun createPaymentMethodForPaypal(
        braintreeNonce: String,
        paypalSecureElement: String,
    ): Result<ApiPaymentMethodResponse, Error>

    public suspend fun createPaypalClientToken(): Result<ApiPaypalClientTokenResponse, Error>
}

public interface PaymentService {
    public suspend fun detachPaymentMethod(paymentMethodId: String): Result<Unit, Error>

    public suspend fun purchaseCreditPackage(
        purchasingPackage: ApiPurchasingCreditPackageRequest,
    ): Result<ApiPurchasedCreditPackageResponse, Error>

    public suspend fun purchasePersonalDiscount(
        purchaseRequest: ApiPersonalDiscountPurchaseRequest,
    ): Result<ApiPersonalDiscountResponse, Error>

    public suspend fun payFailedPayments(request: ApiFailedPaymentRequest): Result<ApiFailedPaymentResponse, Error>
}

public interface RedeemService {
    public suspend fun redeemPromoCode(request: ApiRedeemPromoCodeRequest): Result<ApiRedeemedPromoCodeResponse, Error>

    public suspend fun redeemReferralCode(code: String): Result<Unit, Error>
}

public interface PublicTransportService {
    public suspend fun getPublicTransportSchedules(url: String, time: Instant): Result<List<ApiScheduleResponse>, Error>
}

public interface TicketingService {
    public suspend fun getActiveUserTicketingVouchers(page: Int): Result<List<ApiTicketingVoucherResponse>, Error>

    public suspend fun getInactiveUserTicketingVouchers(page: Int): Result<List<ApiTicketingVoucherResponse>, Error>

    public suspend fun getUserTicketingVoucher(ticketVoucherId: String): Result<ApiTicketingVoucherResponse, Error>

    public suspend fun getAllTicketingProducts(
        type: ApiTicketingProductFilterType,
        rideId: String?,
        page: Int,
    ): Result<List<ApiTicketingProductResponse>, Error>

    public suspend fun purchaseTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): Result<ApiTicketingVoucherResponse, Error>

    public suspend fun renewTicketingVoucher(
        id: String,
        request: ApiRenewTicketingVoucherRequest,
    ): Result<ApiTicketingVoucherResponse, Error>
}

public interface BootstrapService {
    public suspend fun getBootstrap(): Result<ApiBootstrapResponse, Error>
}

public interface ClientService {
    public suspend fun requestClientInfo(): Result<ApiClientInfoResponse, Error>
}

public interface StationsService {
    public suspend fun getStations(request: ApiStationsRequest): Result<List<ApiStationResponse>, Error>
}

public interface VenuesService {
    public suspend fun getVenues(): Result<List<ApiVenueResponse>, Error>
}

private class DefaultIokiService(
    private val iokiApi: IokiApi,
    private val authHeaderProvider: AuthHeaderProvider,
    private val interceptors: Set<ApiErrorInterceptor>,
) : IokiService {
    private val accessToken get() = authHeaderProvider.provide()

    override suspend fun requestPhoneVerification(
        verification: ApiPhoneVerificationRequest,
    ): Result<ApiPhoneVerificationResponse, Error> =
        apiCall<ApiBody<ApiPhoneVerificationResponse>, ApiPhoneVerificationResponse> {
            requestPhoneVerification(ApiBody(verification))
        }

    override suspend fun requestApiToken(request: ApiRequestTokenRequest): Result<ApiRequestTokenResponse, Error> =
        apiCall<ApiBody<ApiRequestTokenResponse>, ApiRequestTokenResponse> {
            requestApiToken(
                ApiBody(
                    request,
                ),
            )
        }

    override suspend fun signUp(request: ApiSignUpRequest): Result<ApiAuthenticatedUserResponse, Error> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            signUp(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun createRide(request: ApiRideRequest): Result<ApiRideResponse, Error> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
            createRide(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun cancelRide(
        rideId: String,
        cancellationRequest: ApiCancellationRequest,
    ): Result<ApiRideResponse, Error> = apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
        cancelRide(
            accessToken,
            rideId,
            ApiBody(cancellationRequest),
        )
    }

    override suspend fun getCancellationVoucher(
        rideId: String,
        request: ApiCancellationVoucherRequest,
    ): Result<ApiCancellationVoucherResponse, Error> =
        apiCall<ApiBody<ApiCancellationVoucherResponse>, ApiCancellationVoucherResponse> {
            getCancellationVoucher(
                accessToken,
                rideId,
                ApiBody(request),
            )
        }

    override suspend fun getRide(rideId: String): Result<ApiRideResponse, Error> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> { getRide(accessToken, rideId) }

    override suspend fun getCurrentRide(): Result<ApiRideResponse, Error> =
        apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> { getCurrentRide(accessToken) }

    override suspend fun requestPhoneCall(rideId: String): Result<Unit, Error> = apiCall<Unit, Unit> {
        requestPhoneCall(accessToken, rideId)
    }

    override suspend fun getRides(type: ApiRideFilterType, page: Int): Result<List<ApiRideResponse>, Error> =
        apiCall<ApiBody<List<ApiRideResponse>>, List<ApiRideResponse>> {
            getRides(
                accessToken,
                type = type.queryValue,
                page = page,
            )
        }

    override suspend fun getRideSeries(rideSeriesId: String): Result<ApiRideSeriesResponse, Error> =
        apiCall<ApiBody<ApiRideSeriesResponse>, ApiRideSeriesResponse> {
            getRideSeries(
                accessToken,
                rideSeriesId,
            )
        }

    override suspend fun getRideSeriesList(page: Int): Result<List<ApiRideSeriesResponse>, Error> =
        apiCall<ApiBody<List<ApiRideSeriesResponse>>, List<ApiRideSeriesResponse>> {
            getRideSeriesList(
                accessToken,
                page,
            )
        }

    override suspend fun createRideSeries(
        rideId: String,
        request: ApiRideSeriesRequest,
    ): Result<ApiRideSeriesResponse, Error> = apiCall<ApiBody<ApiRideSeriesResponse>, ApiRideSeriesResponse> {
        createRideSeries(
            accessToken,
            rideId,
            ApiBody(request),
        )
    }

    override suspend fun submitRating(rideId: String, request: ApiRatingRequest): Result<ApiRatingResponse, Error> =
        apiCall<ApiBody<ApiRatingResponse>, ApiRatingResponse> {
            submitRating(
                accessToken,
                rideId,
                ApiBody(request),
            )
        }

    override suspend fun getPublicTransportSchedules(
        url: String,
        time: Instant,
    ): Result<List<ApiScheduleResponse>, Error> =
        apiCall<ApiBody<List<ApiScheduleResponse>>, List<ApiScheduleResponse>> {
            requestPublicTransportSchedules(
                accessToken,
                url,
                time,
            )
        }

    override suspend fun calculateNewFareForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
    ): Result<ApiFareResponse, Error> = apiCall<ApiBody<ApiFareResponse>, ApiFareResponse> {
        calculateNewFareForRide(
            rideId,
            accessToken,
            ApiBody(ApiCalculateNewFareRequest(passengers)),
        )
    }

    override suspend fun updatePassengersForRide(
        rideId: String,
        passengers: List<ApiPassengerSelectionRequest>,
        rideVersion: Int,
        fareVersion: Int,
        paypalSecureElement: String?,
    ): Result<ApiRideResponse, Error> = apiCall<ApiBody<ApiRideResponse>, ApiRideResponse> {
        val body =
            ApiBody(
                ApiUpdatePassengersForRideRequest(
                    passengers,
                    rideVersion,
                    fareVersion,
                    paypalSecureElement,
                ),
            )
        updatePassengersForRide(rideId, accessToken, body)
    }

    override suspend fun sendTip(rideId: String, request: ApiCreateTipRequest): Result<ApiTipResponse, Error> =
        apiCall<ApiBody<ApiTipResponse>, ApiTipResponse> {
            sendTip(
                accessToken,
                rideId,
                ApiBody(request),
            )
        }

    override suspend fun inquireRide(request: ApiRideInquiryRequest): Result<ApiRideInquiryResponse, Error> =
        apiCall<ApiBody<ApiRideInquiryResponse>, ApiRideInquiryResponse> {
            inquireRide(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun getServiceCreditPackages(): Result<List<ApiPurchasedCreditPackageResponse>, Error> =
        apiCall<ApiBody<List<ApiPurchasedCreditPackageResponse>>, List<ApiPurchasedCreditPackageResponse>> {
            getServiceCreditPackages(
                accessToken,
            )
        }

    override suspend fun getVenues(): Result<List<ApiVenueResponse>, Error> =
        apiCall<ApiBody<List<ApiVenueResponse>>, List<ApiVenueResponse>> { getVenues(accessToken) }

    override suspend fun getUserNotificationSettings(): Result<List<ApiUserNotificationSettingsResponse>?, Error> =
        apiCall<ApiBody<List<ApiUserNotificationSettingsResponse>?>, List<ApiUserNotificationSettingsResponse>?> {
            getUserNotificationSettings(
                accessToken,
            )
        }

    @Suppress("ktlint:standard:max-line-length")
    override suspend fun getAvailableProviderNotificationSettings(): Result<List<ApiProviderNotificationSettingsResponse>, Error> =
        apiCall<ApiBody<List<ApiProviderNotificationSettingsResponse>>, List<ApiProviderNotificationSettingsResponse>> {
            getAvailableProviderNotificationSettings(accessToken)
        }

    @Suppress("ktlint:standard:max-line-length")
    override suspend fun getDefaultProviderNotificationSettings(): Result<List<ApiProviderNotificationSettingsResponse>, Error> =
        apiCall<ApiBody<List<ApiProviderNotificationSettingsResponse>>, List<ApiProviderNotificationSettingsResponse>> {
            getDefaultProviderNotificationSettings(accessToken)
        }

    override suspend fun updateUserNotificationSettings(
        request: ApiUpdateUserNotificationSettingsRequest,
        userId: String,
    ): Result<ApiUserNotificationSettingsResponse, Error> =
        apiCall<ApiBody<ApiUserNotificationSettingsResponse>, ApiUserNotificationSettingsResponse> {
            updateUserNotificationSettings(
                accessToken,
                userId,
                ApiBody(request),
            )
        }

    override suspend fun sendFirebaseDebugRecord(
        debugId: String,
        firebaseDebugRecord: ApiFirebaseDebugRecordRequest,
    ): Result<Unit, Error> = apiCall<Unit, Unit> {
        sendFirebaseDebugRecord(
            accessToken,
            debugId,
            ApiBody(firebaseDebugRecord),
        )
    }

    override suspend fun getBootstrap(): Result<ApiBootstrapResponse, Error> =
        apiCall<ApiBody<ApiBootstrapResponse>, ApiBootstrapResponse> { getBootstrap(accessToken) }

    override suspend fun getUser(): Result<ApiAuthenticatedUserResponse, Error> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            getUser(
                accessToken,
            )
        }

    override suspend fun updateUser(request: ApiUpdateUserRequest): Result<ApiAuthenticatedUserResponse, Error> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updateUser(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun createDevice(deviceRequest: ApiDeviceRequest): Result<ApiDeviceResponse, Error> =
        apiCall<ApiBody<ApiDeviceResponse>, ApiDeviceResponse> {
            createDevice(
                accessToken,
                ApiBody(deviceRequest),
            )
        }

    override suspend fun getFirebaseToken(): Result<ApiFirebaseTokenResponse, Error> =
        apiCall<ApiBody<ApiFirebaseTokenResponse>, ApiFirebaseTokenResponse> {
            getFirebaseToken(
                accessToken,
            )
        }

    override suspend fun marketingApproval(): Result<ApiMarketingResponse, Error> =
        apiCall<ApiBody<ApiMarketingResponse>, ApiMarketingResponse> { marketingApproval(accessToken) }

    override suspend fun marketingRejection(): Result<ApiMarketingResponse, Error> =
        apiCall<ApiBody<ApiMarketingResponse>, ApiMarketingResponse> {
            marketingRejection(
                accessToken,
            )
        }

    override suspend fun deleteUser(): Result<Unit, Error> = apiCall<Unit, Unit> { deleteUser(accessToken) }

    override suspend fun updatePhoneNumber(request: ApiUpdatePhoneNumberRequest): Result<ApiAuthenticatedUserResponse, Error> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updatePhoneNumber(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun createLogPayCustomer(request: ApiLogPayAccountRequest): Result<ApiLogPayUrlResponse, Error> =
        apiCall<ApiBody<ApiLogPayUrlResponse>, ApiLogPayUrlResponse> {
            createLogPayCustomer(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun getLogPayUrl(paymentMethodType: ApiLogPayType): Result<ApiLogPayUrlResponse, Error> =
        apiCall<ApiBody<ApiLogPayUrlResponse>, ApiLogPayUrlResponse> {
            getLogPayUrl(
                accessToken,
                ApiBody(
                    ApiCreateLogPayPaymentMethodRequest(paymentMethodType),
                ),
            )
        }

    override suspend fun updateUserFlags(request: ApiUserFlagsRequest): Result<ApiAuthenticatedUserResponse, Error> =
        apiCall<ApiBody<ApiAuthenticatedUserResponse>, ApiAuthenticatedUserResponse> {
            updateUserFlags(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun solveCaptcha(captchaId: String, captchaRequest: ApiCaptchaRequest): Result<Unit, Error> =
        apiCall<Unit, Unit> { solveCaptcha(captchaId, ApiBody(captchaRequest)) }

    override suspend fun solveClientChallenge(id: String, request: ApiClientChallengeRequest): Result<Unit, Error> =
        apiCall<Unit, Unit> { solveClientChallenge(id, ApiBody(request)) }

    override suspend fun createBooking(rideId: String, request: ApiBookingRequest): Result<Unit, Error> =
        apiCall<Unit, Unit> { createBooking(accessToken, rideId, ApiBody(request)) }

    override suspend fun updateLanguage(): Result<Unit, Error> = apiCall<Unit, Unit> { updateLanguage(accessToken) }

    override suspend fun requestClientInfo(): Result<ApiClientInfoResponse, Error> =
        apiCall<ApiBody<ApiClientInfoResponse>, ApiClientInfoResponse> { getClient() }

    override suspend fun getStations(request: ApiStationsRequest): Result<List<ApiStationResponse>, Error> =
        apiCall<ApiBody<List<ApiStationResponse>>, List<ApiStationResponse>> {
            getStations(
                accessToken,
                request.query,
                request.productId,
                request.xmin,
                request.xmax,
                request.ymin,
                request.ymax,
            )
        }

    override suspend fun detachPaymentMethod(paymentMethodId: String): Result<Unit, Error> =
        apiCall<Unit, Unit> { detachPaymentMethod(accessToken, paymentMethodId) }

    override suspend fun getRedeemedPromoCodes(): Result<List<ApiRedeemedPromoCodeResponse>, Error> =
        apiCall<ApiBody<List<ApiRedeemedPromoCodeResponse>>, List<ApiRedeemedPromoCodeResponse>> {
            getRedeemedPromoCodes(
                accessToken,
            )
        }

    override suspend fun purchaseCreditPackage(
        purchasingPackage: ApiPurchasingCreditPackageRequest,
    ): Result<ApiPurchasedCreditPackageResponse, Error> =
        apiCall<ApiBody<ApiPurchasedCreditPackageResponse>, ApiPurchasedCreditPackageResponse> {
            purchaseCreditPackage(
                accessToken,
                ApiBody(purchasingPackage),
            )
        }

    override suspend fun getAvailablePersonalDiscountTypes(): Result<List<ApiPersonalDiscountTypeResponse>, Error> =
        apiCall<ApiBody<List<ApiPersonalDiscountTypeResponse>>, List<ApiPersonalDiscountTypeResponse>> {
            getAvailablePersonalDiscountTypes(
                accessToken,
            )
        }

    override suspend fun getMyPersonalDiscounts(): Result<List<ApiPersonalDiscountResponse>, Error> =
        apiCall<ApiBody<List<ApiPersonalDiscountResponse>>, List<ApiPersonalDiscountResponse>> {
            getMyPersonalDiscounts(
                accessToken,
            )
        }

    override suspend fun purchasePersonalDiscount(
        purchaseRequest: ApiPersonalDiscountPurchaseRequest,
    ): Result<ApiPersonalDiscountResponse, Error> =
        apiCall<ApiBody<ApiPersonalDiscountResponse>, ApiPersonalDiscountResponse> {
            purchasePersonalDiscount(
                accessToken,
                ApiBody(purchaseRequest),
            )
        }

    override suspend fun redeemPromoCode(request: ApiRedeemPromoCodeRequest): Result<ApiRedeemedPromoCodeResponse, Error> =
        apiCall<ApiBody<ApiRedeemedPromoCodeResponse>, ApiRedeemedPromoCodeResponse> {
            redeemPromoCode(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun requestStripeSetupIntent(): Result<ApiStripeSetupIntentResponse, Error> =
        apiCall<ApiBody<ApiStripeSetupIntentResponse>, ApiStripeSetupIntentResponse> {
            requestStripeSetupIntent(
                accessToken,
            )
        }

    override suspend fun createPaymentMethodFromStripePaymentMethod(
        stripePaymentMethodId: String,
    ): Result<ApiPaymentMethodResponse, Error> = apiCall<ApiBody<ApiPaymentMethodResponse>, ApiPaymentMethodResponse> {
        val data =
            ApiPaymentMethodCreationRequest(
                "stripe",
                ApiPaymentMethodCreationRequest.Details(
                    stripePaymentMethodId = stripePaymentMethodId,
                    null,
                    null,
                ),
            )
        createPaymentMethod(accessToken, ApiBody(data))
    }

    override suspend fun createPaymentMethodForPaypal(
        braintreeNonce: String,
        paypalSecureElement: String,
    ): Result<ApiPaymentMethodResponse, Error> = apiCall<ApiBody<ApiPaymentMethodResponse>, ApiPaymentMethodResponse> {
        val data =
            ApiPaymentMethodCreationRequest(
                "logpay",
                ApiPaymentMethodCreationRequest.Details(
                    braintreeNonce = braintreeNonce,
                    paypalSecureElement = paypalSecureElement,
                    stripePaymentMethodId = null,
                ),
            )
        createPaymentMethod(accessToken, ApiBody(data))
    }

    override suspend fun getPaymentMethods(): Result<List<ApiPaymentMethodResponse>, Error> =
        apiCall<ApiBody<List<ApiPaymentMethodResponse>>, List<ApiPaymentMethodResponse>> {
            getPaymentMethods(
                accessToken,
            )
        }

    override suspend fun redeemReferralCode(code: String): Result<Unit, Error> = apiCall<Unit, Unit> {
        val data = ApiBody(ApiRedeemReferralCodeRequest(code))
        redeemReferralCode(accessToken, data)
    }

    override suspend fun createPaypalClientToken(): Result<ApiPaypalClientTokenResponse, Error> =
        apiCall<ApiBody<ApiPaypalClientTokenResponse>, ApiPaypalClientTokenResponse> {
            createPaypalClientToken(
                accessToken,
            )
        }

    override suspend fun payFailedPayments(request: ApiFailedPaymentRequest): Result<ApiFailedPaymentResponse, Error> =
        apiCall<ApiBody<ApiFailedPaymentResponse>, ApiFailedPaymentResponse> {
            payFailedPayments(
                accessToken,
                ApiBody(request),
            )
        }

    override suspend fun getAllTicketingProducts(
        type: ApiTicketingProductFilterType,
        rideId: String?,
        page: Int,
    ): Result<List<ApiTicketingProductResponse>, Error> =
        apiCall<ApiBody<List<ApiTicketingProductResponse>>, List<ApiTicketingProductResponse>> {
            getAllTicketingProducts(
                accessToken,
                filter = type.queryValue,
                rideId = rideId,
                page = page,
            )
        }

    override suspend fun purchaseTicketingProduct(
        id: String,
        request: ApiPurchaseTicketingProductRequest,
    ): Result<ApiTicketingVoucherResponse, Error> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            purchaseTicketingProduct(
                accessToken,
                id,
                ApiBody(request),
            )
        }

    override suspend fun renewTicketingVoucher(
        id: String,
        request: ApiRenewTicketingVoucherRequest,
    ): Result<ApiTicketingVoucherResponse, Error> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            renewUserTicketingVoucher(
                accessToken,
                id,
                ApiBody(request),
            )
        }

    override suspend fun getActiveUserTicketingVouchers(page: Int): Result<List<ApiTicketingVoucherResponse>, Error> =
        apiCall<ApiBody<List<ApiTicketingVoucherResponse>>, List<ApiTicketingVoucherResponse>> {
            getActiveUserTicketingVouchers(
                accessToken,
                page,
            )
        }

    override suspend fun getInactiveUserTicketingVouchers(page: Int): Result<List<ApiTicketingVoucherResponse>, Error> =
        apiCall<ApiBody<List<ApiTicketingVoucherResponse>>, List<ApiTicketingVoucherResponse>> {
            getInactiveUserTicketingVouchers(
                accessToken,
                page,
            )
        }

    override suspend fun getUserTicketingVoucher(ticketVoucherId: String): Result<ApiTicketingVoucherResponse, Error> =
        apiCall<ApiBody<ApiTicketingVoucherResponse>, ApiTicketingVoucherResponse> {
            getUserTicketingVoucher(
                accessToken,
                ticketVoucherId,
            )
        }

    private suspend inline fun <reified R, reified T> apiCall(
        crossinline block: suspend IokiApi.() -> HttpResponse,
    ): Result<T, Error> {
        return try {
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
}

@Suppress("UNCHECKED_CAST")
internal suspend inline fun <reified R, reified T> mapSuccess(successfulResponse: HttpResponse): Result.Success<T> {
    val body = successfulResponse.body<R>()
    val meta = (body as? ApiBody<*>)?.meta
    val data = when (body) {
        null -> Unit as? T // For Void (no content) body
        is T -> body
        is ApiBody<*> ->
            when {
                body.data is T -> body.data
                T::class == String::class -> body.data.toString()
                T::class == SuccessData::class -> SuccessData(body.data, meta)
                else -> null
            }

        else -> null
    } ?: throw IllegalArgumentException("Failed to convert body '$body' to type ${T::class}")
    return Result.Success(data) as Result.Success<T>
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
