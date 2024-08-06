package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ApiRideRatingCriteriaSerializer::class)
public enum class ApiRideRatingCriteria {
    @SerialName(value = "driver_rating")
    DRIVER_RATING,

    @SerialName(value = "vehicle_rating")
    VEHICLE_RATING,

    @SerialName(value = "service_rating")
    SERVICE_RATING,

    @SerialName(value = "ride_rating")
    RIDE_RATING,

    @SerialName(value = "waiting_time_rating")
    WAITING_TIME_RATING,

    @SerialName(value = "punctuality_rating")
    PUNCTUALITY_RATING,

    @SerialName(value = "vehicle_cleanliness_rating")
    VEHICLE_CLEANLINESS_RATING,

    @SerialName(value = "autonomous_happiness_rating")
    AUTONOMOUS_HAPPINESS,

    @SerialName(value = "autonomous_feeling_of_security_rating")
    AUTONOMOUS_FEELING_OF_SECURITY,

    UNSUPPORTED,
}

internal object ApiRideRatingCriteriaSerializer : KSerializer<ApiRideRatingCriteria> {
    override val descriptor: SerialDescriptor = String.serializer().descriptor

    override fun serialize(encoder: Encoder, value: ApiRideRatingCriteria) {
        encoder.encodeString(
            when (value) {
                ApiRideRatingCriteria.DRIVER_RATING -> "driver_rating"
                ApiRideRatingCriteria.VEHICLE_RATING -> "vehicle_rating"
                ApiRideRatingCriteria.SERVICE_RATING -> "service_rating"
                ApiRideRatingCriteria.RIDE_RATING -> "ride_rating"
                ApiRideRatingCriteria.WAITING_TIME_RATING -> "waiting_time_rating"
                ApiRideRatingCriteria.PUNCTUALITY_RATING -> "punctuality_rating"
                ApiRideRatingCriteria.VEHICLE_CLEANLINESS_RATING -> "vehicle_cleanliness_rating"
                ApiRideRatingCriteria.AUTONOMOUS_HAPPINESS -> "autonomous_happiness_rating"
                ApiRideRatingCriteria.AUTONOMOUS_FEELING_OF_SECURITY -> "autonomous_feeling_of_security_rating"
                ApiRideRatingCriteria.UNSUPPORTED -> "unsupported"
            },
        )
    }

    override fun deserialize(decoder: Decoder): ApiRideRatingCriteria {
        return when (decoder.decodeString()) {
            "driver_rating" -> ApiRideRatingCriteria.DRIVER_RATING
            "vehicle_rating" -> ApiRideRatingCriteria.VEHICLE_RATING
            "service_rating" -> ApiRideRatingCriteria.SERVICE_RATING
            "ride_rating" -> ApiRideRatingCriteria.RIDE_RATING
            "waiting_time_rating" -> ApiRideRatingCriteria.WAITING_TIME_RATING
            "punctuality_rating" -> ApiRideRatingCriteria.PUNCTUALITY_RATING
            "vehicle_cleanliness_rating" -> ApiRideRatingCriteria.VEHICLE_CLEANLINESS_RATING
            "autonomous_happiness_rating" -> ApiRideRatingCriteria.AUTONOMOUS_HAPPINESS
            "autonomous_feeling_of_security_rating" -> ApiRideRatingCriteria.AUTONOMOUS_FEELING_OF_SECURITY
            else -> ApiRideRatingCriteria.UNSUPPORTED
        }
    }
}
