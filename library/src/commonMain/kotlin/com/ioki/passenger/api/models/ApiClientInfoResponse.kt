package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiClientInfoResponse(
    @SerialName(value = "distribution_url") val distributionUrl: String,
    @SerialName(value = "terms_of_service_url") val termsOfServiceUrl: String,
    @SerialName(value = "privacy_policy_url") val privacyPolicyUrl: String,
    @SerialName(value = "imprint_url") val imprintUrl: String,
    @SerialName(value = "help_url") val helpUrl: String?,
    @SerialName(value = "support_email") val supportEmail: String?,
    @SerialName(value = "support_website_url") val supportWebsiteUrl: String?,
    @SerialName(value = "support_phone_number") val supportPhoneNumber: String?,
    @SerialName(value = "sms_support_number") val smsPhoneNumber: String?,
)
