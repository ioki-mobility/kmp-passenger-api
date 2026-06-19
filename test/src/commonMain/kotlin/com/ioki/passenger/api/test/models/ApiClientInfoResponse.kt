package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiClientInfoResponse
import com.ioki.passenger.api.models.ApiVerificationChannelType

public fun createApiClientInfoResponse(
    distributionUrl: String = "",
    termsOfServiceUrl: String = "",
    privacyPolicyUrl: String = "",
    imprintUrl: String = "",
    phoneNumberRequired: Boolean = false,
    emailAddressRequired: Boolean = false,
    helpUrl: String? = null,
    supportEmail: String? = null,
    supportWebsiteUrl: String? = null,
    supportPhoneNumber: String? = null,
    smsPhoneNumber: String? = null,
    preferredVerificationChannel: ApiVerificationChannelType? = null,
    signInVerificationChannels: List<ApiVerificationChannelType> = emptyList(),
    signUpVerificationChannels: List<ApiVerificationChannelType> = emptyList(),
): ApiClientInfoResponse = ApiClientInfoResponse(
    distributionUrl = distributionUrl,
    termsOfServiceUrl = termsOfServiceUrl,
    privacyPolicyUrl = privacyPolicyUrl,
    imprintUrl = imprintUrl,
    phoneNumberRequired = phoneNumberRequired,
    emailAddressRequired = emailAddressRequired,
    helpUrl = helpUrl,
    supportEmail = supportEmail,
    supportWebsiteUrl = supportWebsiteUrl,
    supportPhoneNumber = supportPhoneNumber,
    smsPhoneNumber = smsPhoneNumber,
    preferredVerificationChannel = preferredVerificationChannel,
    signInVerificationChannels = signInVerificationChannels,
    signUpVerificationChannels = signUpVerificationChannels,
)
