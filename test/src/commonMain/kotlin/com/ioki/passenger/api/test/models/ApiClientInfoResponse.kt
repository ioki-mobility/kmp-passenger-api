package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiClientInfoResponse

public fun createApiClientInfoResponse(
    distributionUrl: String = "",
    termsOfServiceUrl: String = "",
    privacyPolicyUrl: String = "",
    imprintUrl: String = "",
    helpUrl: String? = null,
    supportEmail: String? = null,
    supportWebsiteUrl: String? = null,
    supportPhoneNumber: String? = null,
    smsPhoneNumber: String? = null,
): ApiClientInfoResponse = ApiClientInfoResponse(
    distributionUrl = distributionUrl,
    termsOfServiceUrl = termsOfServiceUrl,
    privacyPolicyUrl = privacyPolicyUrl,
    imprintUrl = imprintUrl,
    helpUrl = helpUrl,
    supportEmail = supportEmail,
    supportWebsiteUrl = supportWebsiteUrl,
    supportPhoneNumber = supportPhoneNumber,
    smsPhoneNumber = smsPhoneNumber,
)
