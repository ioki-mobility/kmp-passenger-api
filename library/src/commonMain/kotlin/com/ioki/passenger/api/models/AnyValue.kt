package com.ioki.passenger.api.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull

@Serializable(with = ValueSerializer::class)
public sealed class AnyValue {
    @Serializable
    public data class StringValue(val value: String) : AnyValue()

    @Serializable
    public data class IntValue(val value: Int) : AnyValue()

    @Serializable
    public data class BooleanValue(val value: Boolean) : AnyValue()

    @Serializable
    public data class DoubleValue(val value: Double) : AnyValue()
}

internal object ValueSerializer : KSerializer<AnyValue> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Value")

    override fun serialize(encoder: Encoder, value: AnyValue) {
        when (value) {
            is AnyValue.StringValue -> encoder.encodeSerializableValue(AnyValue.StringValue.serializer(), value)
            is AnyValue.IntValue -> encoder.encodeSerializableValue(AnyValue.IntValue.serializer(), value)
            is AnyValue.BooleanValue -> encoder.encodeSerializableValue(AnyValue.BooleanValue.serializer(), value)
            is AnyValue.DoubleValue -> encoder.encodeSerializableValue(AnyValue.DoubleValue.serializer(), value)
            // Handle other types as needed
        }
    }

    override fun deserialize(decoder: Decoder): AnyValue {
        val input = decoder as? JsonDecoder ?: throw SerializationException("Expected JsonInput for ${this::class}")
        val jsonElement = input.decodeJsonElement()

        // Here we can add logic to determine the type
        return when {
            jsonElement is JsonPrimitive && jsonElement.isString -> AnyValue.StringValue(jsonElement.content)
            jsonElement is JsonPrimitive && jsonElement.intOrNull != null -> AnyValue.IntValue(jsonElement.int)
            jsonElement is JsonPrimitive && jsonElement.booleanOrNull != null ->
                AnyValue.BooleanValue(
                    jsonElement.boolean,
                )
            jsonElement is JsonPrimitive && jsonElement.doubleOrNull != null -> AnyValue.DoubleValue(jsonElement.double)
            else -> throw SerializationException("Unknown type")
        }
    }
}
