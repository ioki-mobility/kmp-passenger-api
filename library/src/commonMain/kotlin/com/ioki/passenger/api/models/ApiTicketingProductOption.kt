package com.ioki.passenger.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiTicketingProductOption(
    val slug: String,
    val name: String,
    val description: String,
    @SerialName(value = "data_type") val dataType: DataType = DataType.UNSUPPORTED,
    @SerialName(value = "data_format") val dataFormat: DataFormat = DataFormat.UNSUPPORTED,
    @SerialName(value = "data_enum") val dataEnum: Boolean,
    @SerialName(value = "enum_items") val enumItems: List<EnumItem>,
    val required: Boolean,
) {

    @Serializable
    public data class EnumItem(
        val slug: String,
        val name: String,
        val description: String,
        val value: String,
    )

    @Serializable
    public enum class DataType {
        @SerialName(value = "boolean")
        BOOLEAN,

        @SerialName(value = "integer")
        INTEGER,

        @SerialName(value = "number")
        NUMBER,

        @SerialName(value = "string")
        STRING,

        @SerialName(value = "object")
        OBJECT,
        UNSUPPORTED,
    }

    @Serializable
    public enum class DataFormat {
        @SerialName(value = "")
        EMPTY,

        @SerialName(value = "date")
        DATE,

        @SerialName(value = "datetime")
        DATETIME,

        @SerialName(value = "geolocation")
        GEOLOCATION,
        UNSUPPORTED,
    }
}
