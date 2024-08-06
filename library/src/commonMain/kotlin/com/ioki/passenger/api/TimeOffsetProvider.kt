package com.ioki.passenger.api

import kotlinx.datetime.LocalDateTime

public interface TimeOffsetProvider {
    public fun setReferenceTime(referenceTime: LocalDateTime)
}

internal val NoopTimeOffsetProvider = object : TimeOffsetProvider {
    override fun setReferenceTime(referenceTime: LocalDateTime) {}
}
