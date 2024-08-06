package com.ioki.passenger.api.models

public enum class ApiRideFilterType(public val queryValue: String) {
    ACTIVE("active"),
    PAST("finished_or_caused_fee"),
    FAILED_PAYMENTS("payment_failed"),
}
