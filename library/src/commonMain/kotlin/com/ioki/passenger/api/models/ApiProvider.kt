package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiProvider(
    val name: String,
    @SerialName(value = "psp")
    val paymentServiceProvider: PaymentServiceProvider,
    @SerialName(value = "ride_payment_method_types")
    val ridePaymentMethodTypes: Set<ApiPaymentMethodType>,
    @SerialName(value = "ticketing_payment_method_types")
    val ticketingPaymentMethodTypes: Set<ApiPaymentMethodType>,
    @SerialName(value = "service_credit_payment_method_types")
    val serviceCreditPaymentMethodTypes: Set<ApiPaymentMethodType>,
    @SerialName(value = "personal_discount_payment_method_types")
    val personalDiscountPaymentMethodTypes: Set<ApiPaymentMethodType>,
    @SerialName(value = "tip_payment_method_types")
    val tipPaymentMethodTypes: Set<ApiPaymentMethodType>,
    @SerialName(value = "stripe_payment_method_types")
    val stripeTypes: Set<ApiStripeType>?,
    @SerialName(value = "logpay_payment_method_types")
    val logPayTypes: Set<ApiLogPayType>?,
    @SerialName(value = "service_credit_options") val creditOptions: CreditOptions?,
    @SerialName(value = "stripe_account_id") val stripeAccountId: String?,
    val features: Features,
    val avatar: ApiAvatar?,
    @SerialName(value = "avatar_darkmode")
    val avatarDarkmode: ApiAvatar?,
    @SerialName(value = "custom_urls") val customUrls: List<CustomUrl>,
) {
    @Serializable
    public data class CustomUrl(val name: String, val url: String, @SerialName(value = "sort_key") val sortKey: Int)

    @Serializable
    public data class CreditOptions(val packages: List<ApiOfferedCreditPackage>)

    @Serializable
    public enum class PaymentServiceProvider {
        @SerialName(value = "no_psp")
        NONE,

        @SerialName(value = "logpay")
        LOGPAY,

        @SerialName(value = "stripe")
        STRIPE,
    }

    @Serializable
    public data class Features(
        @SerialName(value = "payment") val paymentEnabled: Boolean,
        @SerialName(value = "service_credits") val serviceCreditsEnabled: Boolean,
        @SerialName(value = "non_purchasable_personal_discounts") val concessionaryFaresEnabled: Boolean,
        @SerialName(value = "purchasable_personal_discounts") val personalDiscountsEnabled: Boolean,
        @SerialName(value = "promo_codes") val promoCodesEnabled: Boolean,
        @SerialName(value = "analytics_tracking") val analyticsTracking: Boolean,
        @SerialName(value = "user_email_required") val userEmailRequired: Boolean,
        @SerialName(value = "marketing_automation") val marketingAutomation: Boolean,
        val referrals: Referrals?,
        @SerialName(value = "minimum_age_confirmation") val minimumAgeConfirmation: MinimumAgeConfirmation?,
        @SerialName(value = "newsletter") val newsletterEnabled: Boolean,
        @SerialName(value = "receipts") val receiptsEnabled: Boolean,
        @SerialName(value = "apply_for_non_purchasable_personal_discounts")
        val supportsApplyForConcessionaryFare: Boolean,
        @SerialName(value = "tickets") val ticketsEnabled: Boolean,
    ) {
        @Serializable
        public data class Referrals(val description: String)

        @Serializable
        public data class MinimumAgeConfirmation(@SerialName(value = "minimum_age") val minimumAge: Int)

        public companion object {
            public val ALL: Features =
                Features(
                    paymentEnabled = true,
                    serviceCreditsEnabled = true,
                    concessionaryFaresEnabled = true,
                    personalDiscountsEnabled = true,
                    promoCodesEnabled = true,
                    analyticsTracking = true,
                    userEmailRequired = true,
                    marketingAutomation = true,
                    referrals = Referrals(""),
                    minimumAgeConfirmation = MinimumAgeConfirmation(0),
                    newsletterEnabled = true,
                    receiptsEnabled = true,
                    supportsApplyForConcessionaryFare = true,
                    ticketsEnabled = true,
                )
            public val NONE: Features =
                Features(
                    false,
                    serviceCreditsEnabled = false,
                    concessionaryFaresEnabled = false,
                    personalDiscountsEnabled = false,
                    promoCodesEnabled = false,
                    analyticsTracking = false,
                    userEmailRequired = false,
                    marketingAutomation = false,
                    referrals = null,
                    minimumAgeConfirmation = null,
                    newsletterEnabled = false,
                    receiptsEnabled = false,
                    supportsApplyForConcessionaryFare = false,
                    ticketsEnabled = false,
                )
        }
    }
}

public val ApiProvider.Features.permissionCenterEnabled: Boolean
    get() = analyticsTracking || marketingAutomation || newsletterEnabled || receiptsEnabled

public val ApiProvider.allPaymentMethodTypes: Set<ApiPaymentMethodType>
    get() =
        ridePaymentMethodTypes +
            serviceCreditPaymentMethodTypes +
            personalDiscountPaymentMethodTypes +
            tipPaymentMethodTypes
