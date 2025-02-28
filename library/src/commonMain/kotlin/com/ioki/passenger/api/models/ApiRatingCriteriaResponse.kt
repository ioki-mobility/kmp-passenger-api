package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
public data class ApiRatingCriteriaResponse(
    val type: Type,
    val slug: String,
    @SerialName(value = "localized_name") val localizedName: String,
    @SerialName(value = "localized_description") val localizedDescription: String,
    val default: Boolean,
) {
    @Serializable(with = ApiRatingCriteriaResponseTypeSerializer::class)
    public enum class Type {
        @SerialName(value = "rating_criterion")
        RATING_CRITERION,

        UNSUPPORTED,
    }
}

internal object ApiRatingCriteriaResponseTypeSerializer : KSerializer<ApiRatingCriteriaResponse.Type> {
    override val descriptor = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): ApiRatingCriteriaResponse.Type {
        return when (decoder.decodeString()) {
            "rating_criterion" -> ApiRatingCriteriaResponse.Type.RATING_CRITERION
            else -> ApiRatingCriteriaResponse.Type.UNSUPPORTED
        }
    }

    override fun serialize(encoder: Encoder, value: ApiRatingCriteriaResponse.Type) {
        encoder.encodeString(
            when (value) {
                ApiRatingCriteriaResponse.Type.RATING_CRITERION -> "rating_criterion"
                ApiRatingCriteriaResponse.Type.UNSUPPORTED -> "unsupported"
            },
        )
    }
}
