package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAvatar

public fun createApiAvatar(versions: ApiAvatar.Versions? = null): ApiAvatar = ApiAvatar(versions = versions)

public fun createApiAvatarVersions(
    small: ApiAvatar.Versions.ImageData? = null,
    medium: ApiAvatar.Versions.ImageData? = null,
    large: ApiAvatar.Versions.ImageData? = null,
    mini: ApiAvatar.Versions.ImageData? = null,
): ApiAvatar.Versions = ApiAvatar.Versions(
    small = small,
    medium = medium,
    large = large,
    mini = mini,
)

public fun createApiAvatarVersionsImageData(
    width: Int = 0,
    height: Int = 0,
    url: String = "",
): ApiAvatar.Versions.ImageData = ApiAvatar.Versions.ImageData(
    width = width,
    height = height,
    url = url,
)
