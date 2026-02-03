package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiLogPayType
import com.ioki.passenger.api.models.ApiOfferedCreditPackage
import com.ioki.passenger.api.models.ApiPaymentMethodType
import com.ioki.passenger.api.models.ApiProvider
import com.ioki.passenger.api.models.ApiStripeType

public fun createApiProvider(
    name: String = "",
    paymentServiceProvider: ApiProvider.PaymentServiceProvider = ApiProvider.PaymentServiceProvider.NONE,
    ridePaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    ticketingPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    serviceCreditPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    personalDiscountPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    tipPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    stripeTypes: Set<ApiStripeType>? = null,
    logPayTypes: Set<ApiLogPayType>? = null,
    creditOptions: ApiProvider.CreditOptions? = null,
    stripeAccountId: String? = null,
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
    stripeTypes = stripeTypes,
    logPayTypes = logPayTypes,
    creditOptions = creditOptions,
    stripeAccountId = stripeAccountId,
    merchantName = merchantName,
    countryCode = countryCode,
    features = features,
    avatar = avatar,
    avatarDarkmode = avatarDarkmode,
    customUrls = customUrls,
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
