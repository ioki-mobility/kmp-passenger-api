package com.ioki.passenger.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class ApiTipping(val minimum: ApiMoney, val maximum: ApiMoney?, val suggestions: List<ApiMoney>)
