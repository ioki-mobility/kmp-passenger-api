package com.ioki.passenger.api.models

import kotlinx.datetime.LocalDate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiPersonalDiscountTypeResponse(
    val id: String,
    val title: String,
    val description: String,
    @SerialName(value = "price") val price: ApiMoney,
    @SerialName(value = "time_validity_mode")
    @Serializable(with = TimeValidityModeSerializer::class)
    val timeValidityMode: TimeValidityMode?,
    @SerialName(value = "default_duration")
    val defaultDuration: Int?,
    @SerialName(value = "fixed_start_date")
    val fixedStartDate: LocalDate?,
    @SerialName(value = "fixed_end_date")
    val fixedEndDate: LocalDate?,
) {
    @Serializable
    public enum class TimeValidityMode {
        @SerialName(value = "relative_to_creation")
        RELATIVE_TO_CREATION,

        @SerialName(value = "fixed_start_and_end")
        FIXED_START_AND_END,
        UNSUPPORTED,
    }
}

private object TimeValidityModeSerializer :
    KSerializer<ApiPersonalDiscountTypeResponse.TimeValidityMode?> {
    override val descriptor = String.serializer().descriptor

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: ApiPersonalDiscountTypeResponse.TimeValidityMode?) {
        if (value == null) {
            encoder.encodeNull()
            return
        }
        encoder.encodeString(
            when (value) {
                ApiPersonalDiscountTypeResponse.TimeValidityMode.RELATIVE_TO_CREATION ->
                    "relative_to_creation"

                ApiPersonalDiscountTypeResponse.TimeValidityMode.FIXED_START_AND_END ->
                    "fixed_start_and_end"

                ApiPersonalDiscountTypeResponse.TimeValidityMode.UNSUPPORTED ->
                    "unsupported"
            },
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): ApiPersonalDiscountTypeResponse.TimeValidityMode? {
        val stringValue =
            decoder.decodeNullableSerializableValue(String.serializer().nullable) ?: return null

        return when (stringValue) {
            "relative_to_creation" ->
                ApiPersonalDiscountTypeResponse.TimeValidityMode.RELATIVE_TO_CREATION

            "fixed_start_and_end" ->
                ApiPersonalDiscountTypeResponse.TimeValidityMode.FIXED_START_AND_END

            else -> ApiPersonalDiscountTypeResponse.TimeValidityMode.UNSUPPORTED
        }
    }
}
