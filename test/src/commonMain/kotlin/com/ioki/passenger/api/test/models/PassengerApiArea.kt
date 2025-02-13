package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiArea
import com.ioki.passenger.api.models.PassengerApiArea

public fun createPassengerApiArea(
    type: String = "Feature",
    id: String? = null,
    name: String = "name",
    slug: String = "slug",
    areaType: String = "areaType",
    color: String = "color",
    opacity: Float = 0.5f,
    strokeWeight: Int = 1,
    fillColor: String = "fillColor",
    fillOpacity: Float = 0.5f,
    invert: Boolean = false,
    zIndex: Int = 1,
    legendIndex: Int = 1,
    legendTitle: String? = null,
    legendDescription: String? = null,
    area: ApiArea = createApiArea(),
): PassengerApiArea = PassengerApiArea(
    type = type,
    id = id,
    name = name,
    slug = slug,
    areaType = areaType,
    color = color,
    opacity = opacity,
    strokeWeight = strokeWeight,
    fillColor = fillColor,
    fillOpacity = fillOpacity,
    invert = invert,
    zIndex = zIndex,
    legendIndex = legendIndex,
    legendTitle = legendTitle,
    legendDescription = legendDescription,
    area = area,
)
