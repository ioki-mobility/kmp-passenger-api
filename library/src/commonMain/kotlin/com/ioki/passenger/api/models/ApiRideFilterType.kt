package com.ioki.passenger.api.models

public enum class ApiRideFilterType(public val queryValue: String) {
    ACTIVE("active"),
    FINISHED_OR_CAUSED_FEE("finished_or_caused_fee"),
    FINISHED_OR_CAUSED_FEE_OR_CANCELLED_BY_OPERATOR("finished_or_caused_fee_or_cancelled_by_operator"),
    FAILED_PAYMENTS("payment_failed"),
}
