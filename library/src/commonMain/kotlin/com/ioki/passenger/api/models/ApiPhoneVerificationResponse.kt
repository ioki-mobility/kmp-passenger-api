package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiPhoneVerificationResponse(
    @SerialName(value = "phone_number") val phoneNumber: String,
    val captcha: Captcha?,
    @SerialName(value = "client_challenge") val clientChallenge: ClientChallenge?,
) {
    @Serializable
    public data class Captcha(
        val id: String,
        @SerialName(value = "image_url") val imageUrl: String?,
        @SerialName(value = "question_prompt") val questionPrompt: String?,
    )

    @Serializable
    public data class ClientChallenge(
        val id: String,
        val challenge: String,
    )
}
