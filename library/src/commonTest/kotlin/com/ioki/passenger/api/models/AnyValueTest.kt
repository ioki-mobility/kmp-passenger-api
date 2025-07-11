package com.ioki.passenger.api.models

import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AnyValueTest {
    private val json = Json { encodeDefaults = true }

    @Test
    fun stringValue_serialization() {
        val value = AnyValue.StringValue("test")
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("\"test\"", serialized)
    }

    @Test
    fun stringValue_deserialization() {
        val deserialized = json.decodeFromString(AnyValueSerializer, "\"test\"")
        assertEquals(AnyValue.StringValue("test"), deserialized)
    }

    @Test
    fun intValue_serialization() {
        val value = AnyValue.IntValue(42)
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("42", serialized)
    }

    @Test
    fun intValue_deserialization() {
        val deserialized = json.decodeFromString(AnyValueSerializer, "42")
        assertEquals(AnyValue.IntValue(42), deserialized)
    }

    @Test
    fun booleanValue_serialization() {
        val value = AnyValue.BooleanValue(true)
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("true", serialized)
    }

    @Test
    fun booleanValue_deserialization() {
        val deserialized = json.decodeFromString(AnyValueSerializer, "true")
        assertEquals(AnyValue.BooleanValue(true), deserialized)
    }

    @Test
    fun doubleValue_serialization() {
        val value = AnyValue.DoubleValue(3.14)
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("3.14", serialized)
    }

    @Test
    fun doubleValue_deserialization() {
        val deserialized = json.decodeFromString(AnyValueSerializer, "3.14")
        assertEquals(AnyValue.DoubleValue(3.14), deserialized)
    }

    @Test
    fun instantValue_serialization() {
        val instant = Instant.fromEpochMilliseconds(1633072800000L)
        val value = AnyValue.InstantValue(instant)
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("\"2021-10-01T07:20:00Z\"", serialized)
    }

    @Test
    fun instantValue_deserialization() {
        val instant = Instant.fromEpochMilliseconds(1633072800000L)
        val deserialized = json.decodeFromString(AnyValueSerializer, "\"2021-10-01T07:20:00Z\"")
        assertEquals(AnyValue.InstantValue(instant), deserialized)
    }

    @Test
    fun apiPointValue_serialization() {
        val apiPoint = ApiPoint(52.5200, 13.4050)
        val value = AnyValue.ApiPointValue(apiPoint)
        val serialized = json.encodeToString(AnyValueSerializer, value)
        assertEquals("""{"lat":52.52,"lng":13.405}""", serialized)
    }

    @Test
    fun apiPointValue_deserialization() {
        val apiPoint = ApiPoint(52.5200, 13.4050)
        val deserialized = json.decodeFromString(AnyValueSerializer, """{"lat":52.52,"lng":13.405}""")
        assertEquals(AnyValue.ApiPointValue(apiPoint), deserialized)
    }
}
