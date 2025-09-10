package com.ioki.passenger.api.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiLogPayAccountRequest(
    @SerialName(value = "email")
    val emailAddress: String,
    val person: Person,
    @SerialName(value = "address_residence")
    val address: Address,
    @SerialName(value = "payment_method_type")
    @Serializable(with = ApiLogPayTypeSerializer::class)
    val paymentMethodType: ApiLogPayType?,
) {
    @Serializable
    public data class Person(
        @SerialName(value = "forename")
        val firstName: String,
        @SerialName(value = "surname")
        val lastName: String,
        @SerialName(value = "birth")
        val dateOfBirth: String,
    )

    @Serializable
    public data class Address(
        @SerialName(value = "to1")
        val recipient: String,
        @SerialName(value = "street")
        val streetWithHouseNo: String,
        @SerialName(value = "post_code")
        val zipCode: String,
        val place: String,
        val country: String,
    )
}

private object ApiLogPayTypeSerializer : KSerializer<ApiLogPayType?> {
    override val descriptor = String.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: ApiLogPayType?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }

        encoder.encodeString(
            when (value) {
                ApiLogPayType.CARD -> "card"
                ApiLogPayType.SEPA_DEBIT -> "sepa_debit"
                ApiLogPayType.PAYPAL -> "paypal"
                ApiLogPayType.UNSUPPORTED -> "unsupported"
            },
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): ApiLogPayType? {
        val stringValue =
            decoder.decodeNullableSerializableValue(String.serializer().nullable) ?: return null

        return when (stringValue) {
            "card" -> ApiLogPayType.CARD
            "sepa_debit" -> ApiLogPayType.SEPA_DEBIT
            "paypal" -> ApiLogPayType.PAYPAL
            else -> ApiLogPayType.UNSUPPORTED
        }
    }
}
