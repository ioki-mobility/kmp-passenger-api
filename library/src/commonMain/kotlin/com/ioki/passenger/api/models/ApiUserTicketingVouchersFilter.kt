package com.ioki.passenger.api.models

public enum class ApiUserTicketingVouchersFilter(internal val queryValue: String) {
    UPCOMING("upcoming"),
    PROCESSING("processing"),
    CURRENTLY_VALID("currently_valid"),
    EXPIRED("expired"),
}
