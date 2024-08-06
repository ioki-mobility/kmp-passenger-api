package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ApiPublicTransportType {
    @SerialName(value = "bus")
    BUS,

    @SerialName(value = "underground")
    UNDERGROUND,

    @SerialName(value = "tram")
    TRAM,

    @SerialName(value = "long_distance_train")
    TRAIN_LONG_DISTANCE,

    @SerialName(value = "suburban_train")
    TRAIN_SUBURBAN_TRAIN,

    @SerialName(value = "regional_train")
    TRAIN_REGIONAL,
    UNSUPPORTED,
}
