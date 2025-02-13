package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiCaptchaRequest

public fun createApiCaptchaRequest(solution: String = ""): ApiCaptchaRequest = ApiCaptchaRequest(solution = solution)
