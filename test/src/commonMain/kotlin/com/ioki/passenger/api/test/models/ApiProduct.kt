package com.ioki.passenger.api.test.models

import com.ioki.passenger.api.models.ApiAnnouncement
import com.ioki.passenger.api.models.ApiAvatar
import com.ioki.passenger.api.models.ApiBoundingBox
import com.ioki.passenger.api.models.ApiCancellationStatement
import com.ioki.passenger.api.models.PassengerApiArea
import com.ioki.passenger.api.models.ApiProduct
import com.ioki.passenger.api.models.ApiRideOptions
import com.ioki.passenger.api.models.ApiRideRatingCriteria
import com.ioki.passenger.api.models.ApiStationResponse
import com.ioki.passenger.api.models.ApiTimezone
import com.ioki.passenger.api.models.ApiTipping

public fun createApiProduct(
    id: String = "",
    version: Int = 0,
    name: String = "",
    description: String? = null,
    timezone: ApiTimezone = createApiTimezone(),
    drtArea: PassengerApiArea = createApiPassengerArea(),
    intermodalArea: PassengerApiArea? = null,
    boundingBox: ApiBoundingBox? = null,
    defaultMapBoundingBox: ApiBoundingBox? = null,
    rideOptions: ApiRideOptions = createApiRideOptions(),
    productRideOptions: List<ApiProduct.RideOptions> = emptyList(),
    passengerTypes: List<ApiProduct.PassengerType> = emptyList(),
    passengerOptions: List<ApiProduct.PassengerOption> = emptyList(),
    prebookable: Boolean = false,
    adHocBookable: Boolean = false,
    requiresFixedStation: Boolean = false,
    fixedStations: List<ApiStationResponse> = emptyList(),
    announcements: List<ApiAnnouncement> = emptyList(),
    tipping: ApiTipping? = null,
    displayStationsOnMap: Boolean = false,
    cancellationStatements: List<ApiCancellationStatement>? = null,
    features: ApiProduct.Features = createApiProductFeatures(),
    rideRatingCriteria: List<ApiRideRatingCriteria> = emptyList(),
    avatar: ApiAvatar? = null,
    avatarDarkmode: ApiAvatar? = null,
    helpUrl: String? = null,
    supportEmail: String? = null,
    supportWebsiteUrl: String? = null,
    supportPhoneNumber: String? = null,
    paymentMethodRequiredOnBooking: Boolean = false,
): ApiProduct = ApiProduct(
    id = id,
    version = version,
    name = name,
    description = description,
    timezone = timezone,
    drtArea = drtArea,
    intermodalArea = intermodalArea,
    boundingBox = boundingBox,
    defaultMapBoundingBox = defaultMapBoundingBox,
    rideOptions = rideOptions,
    productRideOptions = productRideOptions,
    passengerTypes = passengerTypes,
    passengerOptions = passengerOptions,
    prebookable = prebookable,
    adHocBookable = adHocBookable,
    requiresFixedStation = requiresFixedStation,
    fixedStations = fixedStations,
    announcements = announcements,
    tipping = tipping,
    displayStationsOnMap = displayStationsOnMap,
    cancellationStatements = cancellationStatements,
    features = features,
    rideRatingCriteria = rideRatingCriteria,
    avatar = avatar,
    avatarDarkmode = avatarDarkmode,
    helpUrl = helpUrl,
    supportEmail = supportEmail,
    supportWebsiteUrl = supportWebsiteUrl,
    supportPhoneNumber = supportPhoneNumber,
    paymentMethodRequiredOnBooking = paymentMethodRequiredOnBooking,
)

public fun createApiProductFeatures(
    multipleBookingSolutions: Boolean = false,
    serialBooking: Boolean = false,
    passengerCancellationStatement: Boolean = false,
    prebookingUiAssistance: Boolean = false,
    stationSearch: Boolean = false,
    updatePassengersAfterBooking: Boolean = false,
    venues: Boolean = false,
    showAutonomousOnboarding: Boolean = false,
    passengerNoteToDriver: Boolean = false,
): ApiProduct.Features = ApiProduct.Features(
    multipleBookingSolutions = multipleBookingSolutions,
    serialBooking = serialBooking,
    passengerCancellationStatement = passengerCancellationStatement,
    prebookingUiAssistance = prebookingUiAssistance,
    stationSearch = stationSearch,
    updatePassengersAfterBooking = updatePassengersAfterBooking,
    venues = venues,
    showAutonomousOnboarding = showAutonomousOnboarding,
    passengerNoteToDriver = passengerNoteToDriver,
)

public fun createApiProductRideOptions(
    dataType: ApiProduct.DataType = ApiProduct.DataType.UNSUPPORTED,
    slug: String = "",
    localizedName: String = "",
    optionType: ApiProduct.RideOptions.Type = ApiProduct.RideOptions.Type.DEFAULT,
    bookable: Boolean = false,
): ApiProduct.RideOptions = ApiProduct.RideOptions(
    dataType = dataType,
    slug = slug,
    localizedName = localizedName,
    optionType = optionType,
    bookable = bookable,
)

public fun createApiProductPassengerType(
    slug: String = "",
    localizedName: String = "",
    localizedInfo: String? = null,
    optionType: ApiProduct.PassengerType.Type = ApiProduct.PassengerType.Type.DEFAULT,
    bookable: Boolean = false,
): ApiProduct.PassengerType = ApiProduct.PassengerType(
    slug = slug,
    localizedName = localizedName,
    localizedInfo = localizedInfo,
    optionType = optionType,
    bookable = bookable,
)

public fun createApiProductPassengerOption(
    dataType: ApiProduct.DataType = ApiProduct.DataType.UNSUPPORTED,
    slug: String = "",
    localizedName: String = "",
    localizedInfo: String? = null,
    localizedDescription: String? = null,
    localizedLink: String? = null,
    localizedLinkText: String? = null,
    optionType: ApiProduct.PassengerOption.Type = ApiProduct.PassengerOption.Type.DEFAULT,
    bookable: Boolean = false,
): ApiProduct.PassengerOption = ApiProduct.PassengerOption(
    dataType = dataType,
    slug = slug,
    localizedName = localizedName,
    localizedInfo = localizedInfo,
    localizedDescription = localizedDescription,
    localizedLink = localizedLink,
    localizedLinkText = localizedLinkText,
    optionType = optionType,
    bookable = bookable,
)
