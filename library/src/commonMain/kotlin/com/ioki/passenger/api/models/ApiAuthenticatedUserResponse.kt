package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiAuthenticatedUserResponse(
    override val id: String,
    @SerialName(value = "first_name") val firstName: String?,
    @SerialName(value = "last_name") val lastName: String?,
    val registered: Boolean,
    override val version: Int,
    @SerialName(value = "phone_number") val phoneNumber: String,
    @SerialName(value = "analytics_tracking") val analyticsTracking: Boolean?,
    val email: ApiEmail?,
    @SerialName(value = "current_terms_accepted") val currentTermsAccepted: Boolean,
    @SerialName(value = "referring_user_set") val referringUserSet: Boolean,
    @SerialName(value = "referral_code") val referralCode: String?,
    @SerialName(value = "remaining_referrals") val remainingReferrals: Int?,
    @SerialName(value = "allow_marketing") val allowMarketing: Boolean?,
    @SerialName(value = "airship_named_user_id") val airshipNamedUserId: String?,
    @SerialName(value = "logpay_customer_set") val logpayCustomerSet: Boolean,
    @SerialName(value = "logpay_support_details") val logpaySupportDetails: LogPaySupportDetails?,
    @SerialName(value = "unique_customer_id") val uniqueCustomerId: String?,
    @SerialName(value = "additional_data") val additionalData: ApiAdditionalData?,
) : Entity {
    @Serializable
    public data class LogPaySupportDetails(
        val email: String,
        val subject: String,
        val body: String,
    )
}
