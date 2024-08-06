package com.ioki.passenger.api.result

public object HttpStatusCode {
    public const val UNAUTHORIZED_401: Int = 401
    public const val NOT_FOUND_404: Int = 404
    public const val NOT_ACCEPTABLE_406: Int = 406
    public const val CONFLICT_409: Int = 409
    public const val UNPROCESSABLE_ENTITY_422: Int = 422
    public const val BAD_GATEWAY_502: Int = 502
}
