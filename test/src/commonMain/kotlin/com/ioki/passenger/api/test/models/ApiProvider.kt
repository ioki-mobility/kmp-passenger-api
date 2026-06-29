package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiOfferedCreditPackage
import com.ioki.passenger.api.models.ApiProvider
import com.ioki.passenger.api.models.ApiProvider.PaymentMethodType

public fun createApiProvider(
    name: String = "",
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
    avatarDarkMode: ApiAvatar? = null,
    customUrls: List<ApiProvider.CustomUrl> = emptyList(),
): ApiProvider = ApiProvider(
    name = name,
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
    avatarDarkMode = avatarDarkMode,
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
