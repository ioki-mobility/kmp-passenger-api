package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiProduct(
    override val id: String,
    override val version: Int,
    val name: String,
    val description: String?,
    @SerialName(value = "timezone") val timezone: ApiTimezone,
    @SerialName(value = "drt_area") val drtArea: PassengerApiArea,
    @SerialName(value = "intermodal_area") val intermodalArea: PassengerApiArea?,
    @SerialName(value = "bounding_box")
    val boundingBox: ApiBoundingBox?,
    @SerialName(value = "default_map_bounding_box")
    val defaultMapBoundingBox: ApiBoundingBox?,
    @SerialName(value = "ride_options")
    @Deprecated(
        message =
        "Use 'productRiderOptions', 'passengerTypes' and 'passengerOptions instead. " +
            "Except of 'prebooking_threshold'. Backend will discuss this and come back to us with that.",
    )
    val rideOptions: ApiRideOptions,
    @SerialName(value = "product_ride_options")
    val productRideOptions: List<RideOptions>,
    @SerialName(value = "passenger_types")
    val passengerTypes: List<PassengerType>,
    @SerialName(value = "passenger_options")
    val passengerOptions: List<PassengerOption>,
    val prebookable: Boolean,
    @SerialName(value = "ad_hoc_bookable") val adHocBookable: Boolean,
    @SerialName(value = "requires_fixed_station") val requiresFixedStation: Boolean,
    @SerialName(value = "fixed_stations") val fixedStations: List<ApiStationResponse>,
    val announcements: List<ApiAnnouncement>,
    val tipping: ApiTipping?,
    @SerialName(value = "display_stations_on_map")
    val displayStationsOnMap: Boolean,
    @SerialName(value = "cancellation_statements")
    val cancellationStatements: List<ApiCancellationStatement>?,
    val features: Features,
    @SerialName(value = "ride_rating_criteria")
    val rideRatingCriteria: List<ApiRideRatingCriteria>,
    val avatar: ApiAvatar?,
    @SerialName(value = "avatar_darkmode")
    val avatarDarkmode: ApiAvatar?,
    @SerialName(value = "help_url")
    val helpUrl: String?,
    @SerialName(value = "support_email")
    val supportEmail: String?,
    @SerialName(value = "support_website_url")
    val supportWebsiteUrl: String?,
    @SerialName(value = "support_phone_number")
    val supportPhoneNumber: String?,
    @SerialName(value = "payment_method_required_on_booking")
    val paymentMethodRequiredOnBooking: Boolean,
) : Entity {
    @Serializable
    public data class Features(
        @SerialName(value = "multiple_booking_solutions")
        val multipleBookingSolutions: Boolean,
        @SerialName(value = "serial_booking")
        val serialBooking: Boolean,
        @SerialName(value = "passenger_cancellation_statement")
        val passengerCancellationStatement: Boolean,
        @SerialName(value = "prebooking_ui_assistance")
        val prebookingUiAssistance: Boolean,
        @SerialName(value = "station_search")
        val stationSearch: Boolean,
        @SerialName(value = "update_passengers_after_booking")
        val updatePassengersAfterBooking: Boolean,
        val venues: Boolean,
        @SerialName(value = "show_autonomous_onboarding")
        val showAutonomousOnboarding: Boolean,
    )

    @Serializable
    public data class RideOptions(
        @SerialName(value = "data_type") val dataType: DataType = DataType.UNSUPPORTED,
        val slug: String,
        @SerialName(value = "localized_name") val localizedName: String,
        @SerialName(value = "option_type") val optionType: Type = Type.DEFAULT,
        @SerialName(value = "bookable") val bookable: Boolean,
    ) {
        @Serializable
        public enum class Type {
            @SerialName(value = "book_for_others")
            BOOK_FOR_OTHERS,

            @SerialName(value = "default")
            DEFAULT,

            @SerialName(value = "default_alt")
            DEFAULT_ALT,

            @SerialName(value = "storage")
            STORAGE,
        }
    }

    @Serializable
    public data class PassengerType(
        val slug: String,
        @SerialName(value = "localized_name") val localizedName: String,
        @SerialName(value = "localized_info") val localizedInfo: String?,
        @SerialName(value = "option_type") val optionType: Type = Type.DEFAULT,
        @SerialName(value = "bookable") val bookable: Boolean,
    ) {
        @Serializable
        public enum class Type {
            @SerialName(value = "adult")
            ADULT,

            @SerialName(value = "child")
            CHILD,

            @SerialName(value = "default")
            DEFAULT,

            @SerialName(value = "default_alt")
            DEFAULT_ALT,

            @SerialName(value = "infant")
            INFANT,
        }
    }

    @Serializable
    public data class PassengerOption(
        @SerialName(value = "data_type") val dataType: DataType = DataType.UNSUPPORTED,
        val slug: String,
        @SerialName(value = "localized_name") val localizedName: String,
        @SerialName(value = "localized_info") val localizedInfo: String?,
        @SerialName(value = "localized_description") val localizedDescription: String?,
        @SerialName(value = "localized_link") val localizedLink: String?,
        @SerialName(value = "localized_link_text") val localizedLinkText: String?,
        @SerialName(value = "option_type") val optionType: Type = Type.DEFAULT,
        @SerialName(value = "bookable") val bookable: Boolean,
    ) {
        @Serializable
        public enum class Type {
            @SerialName(value = "accompanying")
            ACCOMPANYING,

            @SerialName(value = "bahncard")
            BAHNCARD,

            @SerialName(value = "bicycle")
            BICYCLE,

            @SerialName(value = "childseat")
            CHILDSEAT,

            @SerialName(value = "default")
            DEFAULT,

            @SerialName(value = "default_alt")
            DEFAULT_ALT,

            @SerialName(value = "dog")
            DOG,

            @SerialName(value = "german_railway")
            GERMAN_RAILWAY,

            @SerialName(value = "luggage")
            LUGGAGE,

            @SerialName(value = "national_ticket")
            NATIONAL_TICKET,

            @SerialName(value = "pt_ticket")
            PT_TICKET,

            @SerialName(value = "pushchair")
            PUSHCHAIR,

            @SerialName(value = "walker")
            WALKER,

            @SerialName(value = "wheelchair")
            WHEELCHAIR,

            @SerialName(value = "id_card")
            ID_CARD,

            @SerialName(value = "disabled_pass")
            DISABLED_PASS,
        }
    }

    @Serializable
    public enum class DataType {
        @SerialName(value = "boolean")
        BOOLEAN,

        @SerialName(value = "integer")
        INTEGER,

        @SerialName(value = "string")
        STRING,
        UNSUPPORTED,
    }
}
