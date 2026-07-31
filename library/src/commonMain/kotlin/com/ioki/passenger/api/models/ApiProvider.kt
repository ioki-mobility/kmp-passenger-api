package com.ioki.passenger.api.models

import com.ioki.passenger.api.models.ApiProvider.PaymentMethodType
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.NothingSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
public data class ApiProvider(
    val name: String,
    @SerialName(value = "payment_service_provider")
    val paymentServiceProvider: PaymentServiceProvider?,
    @SerialName(value = "ride_payment_method_types")
    val ridePaymentMethodTypes: Set<PaymentMethodType>,
    @SerialName(value = "ticketing_payment_method_types")
    val ticketingPaymentMethodTypes: Set<PaymentMethodType>,
    @SerialName(value = "service_credit_payment_method_types")
    val serviceCreditPaymentMethodTypes: Set<PaymentMethodType>,
    @SerialName(value = "personal_discount_payment_method_types")
    val personalDiscountPaymentMethodTypes: Set<PaymentMethodType>,
    @SerialName(value = "tip_payment_method_types")
    val tipPaymentMethodTypes: Set<PaymentMethodType>,
    @SerialName(value = "service_credit_options") val creditOptions: CreditOptions?,
    @SerialName(value = "merchant_name") val merchantName: String?,
    @SerialName(value = "country_code") val countryCode: String,
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

    @Serializable(with = PaymentMethodTypeSerializer::class)
    public enum class PaymentMethodType {
        @SerialName(value = "cash")
        CASH,

        @SerialName(value = "psp_provided")
        PSP_PROVIDED,

        @SerialName(value = "public_transport_ticket")
        PUBLIC_TRANSPORT_TICKET,

        @SerialName(value = "service_credits")
        SERVICE_CREDITS,

        @SerialName(value = "pos_payment")
        POS_PAYMENT,
        UNSUPPORTED,
    }
}

internal object PaymentMethodTypeSerializer : KSerializer<PaymentMethodType> {
    override val descriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): PaymentMethodType = when (decoder.decodeString()) {
        "cash" -> PaymentMethodType.CASH
        "psp_provided" -> PaymentMethodType.PSP_PROVIDED
        "public_transport_ticket" -> PaymentMethodType.PUBLIC_TRANSPORT_TICKET
        "service_credits" -> PaymentMethodType.SERVICE_CREDITS
        "pos_payment" -> PaymentMethodType.POS_PAYMENT
        else -> PaymentMethodType.UNSUPPORTED
    }

    override fun serialize(encoder: Encoder, value: PaymentMethodType) {
        encoder.encodeString(
            when (value) {
                PaymentMethodType.CASH -> "cash"
                PaymentMethodType.PSP_PROVIDED -> "psp_provided"
                PaymentMethodType.PUBLIC_TRANSPORT_TICKET -> "public_transport_ticket"
                PaymentMethodType.SERVICE_CREDITS -> "service_credits"
                PaymentMethodType.POS_PAYMENT -> "pos_payment"
                PaymentMethodType.UNSUPPORTED -> "unsupported"
            },
        )
    }
}

public val ApiProvider.Features.permissionCenterEnabled: Boolean
    get() = analyticsTracking || marketingAutomation || newsletterEnabled || receiptsEnabled

public val ApiProvider.allPaymentMethodTypes: Set<PaymentMethodType>
    get() =
        ridePaymentMethodTypes +
            serviceCreditPaymentMethodTypes +
            personalDiscountPaymentMethodTypes +
            tipPaymentMethodTypes

internal object PaymentServiceProviderSerializer : KSerializer<PaymentServiceProvider?> {
    override val descriptor: SerialDescriptor = PaymentServiceProvider.Stripe.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: PaymentServiceProvider?) = when (value) {
        is PaymentServiceProvider.Stripe ->
            encoder.encodeNullableSerializableValue(PaymentServiceProvider.Stripe.serializer(), value)
        is PaymentServiceProvider.LogPay ->
            encoder.encodeNullableSerializableValue(PaymentServiceProvider.LogPay.serializer(), value)
        else -> encoder.encodeNullableSerializableValue(NothingSerializer(), null)
    }

    override fun deserialize(decoder: Decoder): PaymentServiceProvider? {
        val input = decoder as? JsonDecoder ?: error("Only Json format is supported")
        val element = input.decodeJsonElement()
        val type = element.jsonObject["type"]?.jsonPrimitive?.content
        return when (type) {
            "payment_service_provider/stripe" ->
                input.json.decodeFromJsonElement(PaymentServiceProvider.Stripe.serializer(), element)
            "payment_service_provider/logpay" ->
                input.json.decodeFromJsonElement(PaymentServiceProvider.LogPay.serializer(), element)
            else -> null
        }
    }
}

@Serializable(PaymentServiceProviderSerializer::class)
public sealed class PaymentServiceProvider {
    @Serializable
    public data class Stripe(
        @SerialName(value = "stripe_account_id") val stripeAccountId: String?,
        @SerialName(value = "stripe_payment_method_types") val stripeTypes: List<ApiStripeType>?,
        @SerialName(value = "google_pay_supported") val googlePaySupported: Boolean,
    ) : PaymentServiceProvider()

    @Serializable
    public data class LogPay(
        @SerialName(value = "logpay_payment_method_types") val logPayTypes: List<ApiLogPayType>?,
        @SerialName(value = "use_legacy_paypal_flow") val useLegacyPaypalFlow: Boolean,
    ) : PaymentServiceProvider()
}
