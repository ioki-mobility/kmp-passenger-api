package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiOfferedCreditPackage
import com.ioki.passenger.api.models.ApiProvider
import com.ioki.passenger.api.models.ApiProvider.PaymentMethodType
import com.ioki.passenger.api.models.ApiStripeType
import com.ioki.passenger.api.models.PaymentServiceProvider

public fun createApiProvider(
    name: String = "",
    paymentServiceProvider: PaymentServiceProvider? = null,
    ridePaymentMethodTypes: Set<PaymentMethodType> = emptySet(),
    ticketingPaymentMethodTypes: Set<PaymentMethodType> = emptySet(),
    serviceCreditPaymentMethodTypes: Set<PaymentMethodType> = emptySet(),
    personalDiscountPaymentMethodTypes: Set<PaymentMethodType> = emptySet(),
    tipPaymentMethodTypes: Set<PaymentMethodType> = emptySet(),
    creditOptions: ApiProvider.CreditOptions? = null,
    merchantName: String? = null,
    countryCode: String = "",
    features: ApiProvider.Features = createApiProviderFeatures(),
    avatar: ApiAvatar? = null,
    avatarDarkmode: ApiAvatar? = null,
    customUrls: List<ApiProvider.CustomUrl> = emptyList(),
): ApiProvider = ApiProvider(
    name = name,
    paymentServiceProvider = paymentServiceProvider,
    ridePaymentMethodTypes = ridePaymentMethodTypes,
    ticketingPaymentMethodTypes = ticketingPaymentMethodTypes,
    serviceCreditPaymentMethodTypes = serviceCreditPaymentMethodTypes,
    personalDiscountPaymentMethodTypes = personalDiscountPaymentMethodTypes,
    tipPaymentMethodTypes = tipPaymentMethodTypes,
    creditOptions = creditOptions,
    merchantName = merchantName,
    countryCode = countryCode,
    features = features,
    avatar = avatar,
    avatarDarkmode = avatarDarkmode,
    customUrls = customUrls,
)

public fun createStripePaymentServiceProvider(
    stripeAccountId: String? = null,
    stripeTypes: List<ApiStripeType>? = null,
    googlePaySupported: Boolean = false,
): PaymentServiceProvider.Stripe = PaymentServiceProvider.Stripe(
    googlePaySupported = googlePaySupported,
    stripeTypes = stripeTypes,
    stripeAccountId = stripeAccountId,
)

public fun createLogPayPaymentServiceProvider(
    logPayTypes: List<ApiLogPayType>? = null,
    useLegacyPaypalFlow: Boolean = false,
): PaymentServiceProvider.LogPay = PaymentServiceProvider.LogPay(
    logPayTypes = logPayTypes,
    useLegacyPaypalFlow = useLegacyPaypalFlow,
)

public fun createApiProviderCreditOptions(
    packages: List<ApiOfferedCreditPackage> = emptyList(),
): ApiProvider.CreditOptions = ApiProvider.CreditOptions(
    packages = packages,
)

public fun createApiProviderFeatures(
    paymentEnabled: Boolean = false,
    serviceCreditsEnabled: Boolean = false,
    concessionaryFaresEnabled: Boolean = false,
    personalDiscountsEnabled: Boolean = false,
    promoCodesEnabled: Boolean = false,
    analyticsTracking: Boolean = false,
    userEmailRequired: Boolean = false,
    marketingAutomation: Boolean = false,
    referrals: ApiProvider.Features.Referrals? = null,
    minimumAgeConfirmation: ApiProvider.Features.MinimumAgeConfirmation? = null,
    newsletterEnabled: Boolean = false,
    receiptsEnabled: Boolean = false,
    supportsApplyForConcessionaryFare: Boolean = false,
    ticketsEnabled: Boolean = false,
): ApiProvider.Features = ApiProvider.Features(
    paymentEnabled = paymentEnabled,
    serviceCreditsEnabled = serviceCreditsEnabled,
    concessionaryFaresEnabled = concessionaryFaresEnabled,
    personalDiscountsEnabled = personalDiscountsEnabled,
    promoCodesEnabled = promoCodesEnabled,
    analyticsTracking = analyticsTracking,
    userEmailRequired = userEmailRequired,
    marketingAutomation = marketingAutomation,
    referrals = referrals,
    minimumAgeConfirmation = minimumAgeConfirmation,
    newsletterEnabled = newsletterEnabled,
    receiptsEnabled = receiptsEnabled,
    supportsApplyForConcessionaryFare = supportsApplyForConcessionaryFare,
    ticketsEnabled = ticketsEnabled,
)

public fun createApiProviderCustomUrl(name: String = "", url: String = "", sortKey: Int = 0): ApiProvider.CustomUrl =
    ApiProvider.CustomUrl(name = name, url = url, sortKey = sortKey)
