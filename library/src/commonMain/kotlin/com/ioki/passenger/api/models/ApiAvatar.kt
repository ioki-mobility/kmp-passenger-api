package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiAvatar(val versions: Versions?) {
    @Serializable
    public data class Versions(
        val small: ImageData?,
        val medium: ImageData?,
        val large: ImageData?,
        val mini: ImageData?,
    ) {
        @Serializable
        public data class ImageData(val width: Int, val height: Int, val url: String)
    }
}
