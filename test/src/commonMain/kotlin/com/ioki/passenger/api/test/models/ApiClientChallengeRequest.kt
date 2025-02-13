package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiClientChallengeRequest

public fun createApiClientChallengeRequest(solution: String = "", nonce: String = ""): ApiClientChallengeRequest =
    ApiClientChallengeRequest(solution = solution, nonce = nonce)
