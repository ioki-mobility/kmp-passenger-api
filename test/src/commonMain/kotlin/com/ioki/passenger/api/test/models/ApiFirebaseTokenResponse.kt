package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiFirebaseTokenResponse

public fun createApiFirebaseTokenResponse(jwt: String = "", encryptionKey: String = ""): ApiFirebaseTokenResponse =
    ApiFirebaseTokenResponse(jwt = jwt, encryptionKey = encryptionKey)
