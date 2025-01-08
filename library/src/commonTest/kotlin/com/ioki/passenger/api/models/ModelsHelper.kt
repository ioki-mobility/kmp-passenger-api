package com.ioki.passenger.api.models

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration.Companion.days

fun createApiProvider(
    name: String = "",
    paymentServiceProvider: ApiProvider.PaymentServiceProvider = ApiProvider.PaymentServiceProvider.NONE,
    ridePaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    ticketingPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    serviceCreditPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    personalDiscountPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    tipPaymentMethodTypes: Set<ApiPaymentMethodType> = emptySet(),
    stripeTypes: Set<ApiStripeType>? = null,
    logPayTypes: Set<ApiLogPayType>? = null,
    creditOptions: ApiProvider.CreditOptions? = null,
    features: ApiProvider.Features = ApiProvider.Features.NONE,
    stripeAccountId: String? = null,
    avatar: ApiAvatar? = null,
    avatarDarkmode: ApiAvatar? = null,
    customUrls: List<ApiProvider.CustomUrl> = emptyList(),
): ApiProvider = ApiProvider(
    name = name,
    paymentServiceProvider = paymentServiceProvider,
    ridePaymentMethodTypes = ridePaymentMethodTypes,
    ticketingPaymentMethodTypes = ticketingPaymentMethodTypes,
    serviceCreditPaymentMethodTypes = serviceCreditPaymentMethodTypes,
    personalDiscountPaymentMethodTypes = personalDiscountPaymentMethodTypes,
    tipPaymentMethodTypes = tipPaymentMethodTypes,
    stripeTypes = stripeTypes,
    logPayTypes = logPayTypes,
    creditOptions = creditOptions,
    features = features,
    stripeAccountId = stripeAccountId,
    avatar = avatar,
    avatarDarkmode = avatarDarkmode,
    customUrls = customUrls,
)

fun createApiClientInfo(
    supportEmail: String? = null,
    supportWebsiteUrl: String? = null,
    smsPhoneNumber: String? = null,
    phoneNumber: String? = null,
    termsOfServiceUrl: String = "",
    privacyPolicyUrl: String = "",
    imprintUrl: String = "",
    helpUrl: String? = null,
    distributionUrl: String = "",
): ApiClientInfoResponse = ApiClientInfoResponse(
    distributionUrl = distributionUrl,
    privacyPolicyUrl = privacyPolicyUrl,
    termsOfServiceUrl = termsOfServiceUrl,
    imprintUrl = imprintUrl,
    helpUrl = helpUrl,
    supportEmail = supportEmail,
    supportWebsiteUrl = supportWebsiteUrl,
    smsPhoneNumber = smsPhoneNumber,
    supportPhoneNumber = phoneNumber,
)

fun createApiProduct(
    id: String = "product-id",
    version: Int = 1,
    timezone: ApiTimezone = createApiTimezone(),
    name: String = "product-name",
    announcements: List<ApiAnnouncement> = emptyList(),
    boundingBox: ApiBoundingBox? = ApiBoundingBox(ApiPoint(1.0, 2.0), ApiPoint(3.0, 4.0)),
    defaultMapBoundingBox: ApiBoundingBox? = null,
    prebookable: Boolean = true,
    adHocBookable: Boolean = true,
    rideOptions: ApiRideOptions = createApiRideOptions(),
    displayStationsOnMap: Boolean = false,
    area: ApiArea? = ApiArea("polygon", mutableListOf()),
    requiresFixedStation: Boolean = false,
    fixedStations: List<ApiStationResponse> = emptyList(),
    rideRatingCriteria: List<ApiRideRatingCriteria> = emptyList(),
    features: ApiProduct.Features = createApiProductFeatures(),
    avatar: ApiAvatar? = null,
    avatarDarkmode: ApiAvatar? = null,
    cancellationStatements: List<ApiCancellationStatement>? = null,
    helpUrl: String? = null,
    supportEmail: String? = null,
    supportWebsiteUrl: String? = null,
    supportPhoneNumber: String? = null,
    passengerOptions: List<ApiProduct.PassengerOption> = emptyList(),
    passengerTypes: List<ApiProduct.PassengerType> = emptyList(),
    productRideOptions: List<ApiProduct.RideOptions> = emptyList(),
    paymentMethodRequiredOnBooking: Boolean = false,
    tipping: ApiTipping? = null,
    drtArea: PassengerApiArea = createPassengerApiArea(),
    intermodalArea: PassengerApiArea? = null,
): ApiProduct = ApiProduct(
    id = id,
    version = version,
    name = name,
    timezone = timezone,
    boundingBox = boundingBox,
    defaultMapBoundingBox = defaultMapBoundingBox,
    rideOptions = rideOptions,
    prebookable = prebookable,
    adHocBookable = adHocBookable,
    requiresFixedStation = requiresFixedStation,
    fixedStations = fixedStations,
    announcements = announcements,
    displayStationsOnMap = displayStationsOnMap,
    description = null,
    tipping = tipping,
    rideRatingCriteria = rideRatingCriteria,
    avatar = avatar,
    avatarDarkmode = avatarDarkmode,
    cancellationStatements = cancellationStatements,
    helpUrl = helpUrl,
    supportEmail = supportEmail,
    supportWebsiteUrl = supportWebsiteUrl,
    supportPhoneNumber = supportPhoneNumber,
    features = features,
    passengerOptions = passengerOptions,
    passengerTypes = passengerTypes,
    productRideOptions = productRideOptions,
    paymentMethodRequiredOnBooking = paymentMethodRequiredOnBooking,
    drtArea = drtArea,
    intermodalArea = intermodalArea,
)

fun createPassengerApiArea(
    color: String = "",
    opacity: Float = Float.MIN_VALUE,
    strokeWeight: Int = 0,
    fillColor: String = "",
    fillOpacity: Float = Float.MIN_VALUE,
    invert: Boolean = false,
    area: ApiArea = ApiArea("MultiPolygon", emptyList()),
): PassengerApiArea = PassengerApiArea(
    type = "",
    id = "",
    name = "",
    slug = "",
    areaType = "",
    color = color,
    opacity = opacity,
    strokeWeight = strokeWeight,
    fillColor = fillColor,
    fillOpacity = fillOpacity,
    invert = invert,
    zIndex = 0,
    legendIndex = 0,
    legendTitle = null,
    legendDescription = null,
    area = area,
)

fun createApiStation(
    id: String = "",
    lat: Double = Double.MIN_VALUE,
    lng: Double = Double.MIN_VALUE,
    locationName: String = "",
    visibleOnMap: Boolean = false,
): ApiStationResponse = ApiStationResponse(
    id = id,
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = null,
    postalCode = null,
    streetNumber = null,
    city = null,
    county = null,
    country = null,
    description = null,
    avatar = null,
    publicTransportTypes = null,
    publicTransportScheduleUrl = null,
    visibleOnMap = visibleOnMap,
)

fun createApiRideOptions(
    passengers: ApiRideOptions.Passenger = createRideOptionsPassenger(),
    destinationTimeBasedMatching: Boolean = false,
    preBookingThreshold: ApiRideOptions.PreBookingThreshold? = null,
): ApiRideOptions = ApiRideOptions(
    passengers = passengers,
    destinationTimeBasedMatching = destinationTimeBasedMatching,
    preBookingThreshold = preBookingThreshold,
)

fun createRideOptionsPassenger(nameRequiredIfNoPublicTransportTicket: Boolean = false): ApiRideOptions.Passenger =
    ApiRideOptions.Passenger(nameRequiredIfNoPublicTransportTicket)

fun createApiAnnouncement(
    id: String = "1234",
    title: String = "dummy announcement",
    text: String = "this is an announcement",
    startsAt: Instant = Clock.System.now(),
    endsAt: Instant = Clock.System.now().plus(30.days),
    createdAt: Instant = Instant.parse("1970-01-01T00:00:00Z"),
    updatedAt: Instant = Instant.parse("1970-01-01T00:00:00Z"),
    severity: ApiAnnouncement.Severity = ApiAnnouncement.Severity.WARNING,
    showOnEveryAppStart: Boolean = false,
    additionalDetailsUrl: String? = null,
): ApiAnnouncement = ApiAnnouncement(
    id = id,
    title = title,
    text = text,
    startsAt = startsAt,
    endsAt = endsAt,
    createdAt = createdAt,
    updatedAt = updatedAt,
    severity = severity,
    showOnEveryAppStart = showOnEveryAppStart,
    additionalInformationUrl = additionalDetailsUrl,
)

fun createApiTimezone(identifier: String = "Europe/Berlin"): ApiTimezone = ApiTimezone(identifier)

fun createApiFare(
    id: String = "",
    version: Int = 0,
    bookingPrice: ApiMoney = ApiMoney(0, "EUR"),
    bookingPriceType: ApiFareResponse.BookingPriceType = ApiFareResponse.BookingPriceType.FIXED,
    finalPrice: ApiMoney? = null,
    showCustomMessage: Boolean = false,
): ApiFareResponse = ApiFareResponse(
    id = id,
    version = version,
    bookingPrice = bookingPrice,
    bookingPriceType = bookingPriceType,
    finalPrice = finalPrice,
    showCustomMessage = showCustomMessage,
)

fun createApiLocation(
    lat: Double = Double.MIN_VALUE,
    lng: Double = Double.MIN_VALUE,
    locationName: String? = null,
    streetName: String? = null,
    streetNumber: String? = null,
    postalCode: String? = null,
    city: String? = null,
    county: String? = null,
    country: String? = null,
    type: String? = null,
    time: Instant? = null,
    waypointType: String? = null,
    stationId: String? = null,
    walkingDuration: Long? = null,
    walkingTrack: String? = null,
    station: ApiStationResponse? = null,
    displayTimes: List<Instant> = emptyList(),
): ApiLocation = ApiLocation(
    lat = lat,
    lng = lng,
    locationName = locationName,
    streetName = streetName,
    streetNumber = streetNumber,
    postalCode = postalCode,
    city = city,
    county = county,
    country = country,
    type = type,
    time = time,
    waypointType = waypointType,
    stationId = stationId,
    walkingDuration = walkingDuration,
    walkingTrack = walkingTrack,
    station = station,
    displayTimes = displayTimes,
)

fun createApiVehicle(
    licensePlate: String = "",
    nickname: String = "",
    manufacturer: String = "",
    model: String = "",
    fuelType: String = "",
    operatorInfo: String? = null,
    avatar: ApiAvatar? = null,
    seats: Int = 0,
    storageSpace: Int = 0,
    autonomous: Boolean = false,
    supportsOpenDoorRequests: Boolean = false,
    doorControlAvailable: Boolean = false,
): ApiVehicle = ApiVehicle(
    licensePlate = licensePlate,
    nickname = nickname,
    manufacturer = manufacturer,
    model = model,
    fuelType = fuelType,
    operatorInfo = operatorInfo,
    avatar = avatar,
    seats = seats,
    storageSpaces = storageSpace,
    autonomous = autonomous,
    supportsOpenDoorRequests = supportsOpenDoorRequests,
    doorControlAvailable = doorControlAvailable,
)

fun createApiProductFeatures(
    multipleBookingSolutions: Boolean = true,
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

fun createApiPaymentMethodRequest(
    paymentMethodType: ApiPaymentMethodType = ApiPaymentMethodType.UNSUPPORTED,
    id: String? = null,
    summary: ApiPaymentMethodRequest.Summary? = null,
): ApiPaymentMethodRequest = ApiPaymentMethodRequest(paymentMethodType, id, summary)
