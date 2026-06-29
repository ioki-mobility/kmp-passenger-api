package com.ioki.passenger.api.models

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable
public data class ApiBootstrapResponse(
    val provider: ApiProvider,
    val products: List<ApiProduct>,
    val client: ApiClientInfoResponse,
    @SerialName(value = "payment_service_provider") val paymentServiceProvider: PaymentServiceProvider?,
    @SerialName(value = "rides_with_failed_payments") val ridesWithFailedPayments: List<ApiRideResponse>,
    @SerialName(value = "renewable_ticketing_vouchers")
    val renewableTicketingVouchers: List<ApiTicketingVoucherResponse>,
    @SerialName(value = "product_support_uris") val productSupportUris: List<ProductSupportUri>,
) {
    @Serializable
    public data class ProductSupportUri(
        @SerialName(value = "product_id") val productId: String,
        @SerialName(value = "support_website_uri") val supportWebsiteUri: String,
    )
}

internal object PaymentServiceProviderSerializer : JsonContentPolymorphicSerializer<PaymentServiceProvider>(
    PaymentServiceProvider::class,
) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<PaymentServiceProvider> {
        val jsonObject = element.jsonObject
        val type = jsonObject.getValue("type").jsonPrimitive.content
        return when (type) {
            "payment_service_provider/stripe" -> PaymentServiceProvider.Stripe.serializer()
            "payment_service_provider/logpay" -> PaymentServiceProvider.LogPay.serializer()
            else -> throw IllegalArgumentException("Unsupported PaymentServiceProvider type.")
        }
    }
}

@Serializable(PaymentServiceProviderSerializer::class)
public sealed class PaymentServiceProvider {
    public abstract val type: Type

    @Serializable
    public data class Stripe(
        @SerialName(value = "stripe_account_id") val stripeAccountId: String?,
        @SerialName(value = "stripe_payment_method_types") val stripeTypes: List<ApiStripeType>?,
        @SerialName(value = "google_pay_supported") val googlePaySupported: Boolean,
    ) : PaymentServiceProvider() {
        override val type: Type = Type.STRIPE
    }

    @Serializable
    public data class LogPay(
        @SerialName(value = "logpay_payment_method_types") val logPayTypes: List<ApiLogPayType>?,
    ) : PaymentServiceProvider() {
        override val type: Type = Type.LOGPAY
    }

    @Serializable
    public enum class Type {
        @SerialName(value = "payment_service_provider/logpay")
        LOGPAY,

        @SerialName(value = "payment_service_provider/stripe")
        STRIPE,
    }
}
