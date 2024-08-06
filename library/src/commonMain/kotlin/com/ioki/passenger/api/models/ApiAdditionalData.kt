package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiAdditionalData(
    @SerialName(value = "marketing_automation_push_channel_enabled")
    val marketingAutomationPushChannelEnabled: Boolean?,
    @SerialName(value = "marketing_automation_message_center_channel_enabled")
    val marketingAutomationMessageCenterChannelEnabled: Boolean?,
)
