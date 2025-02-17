package com.ioki.passenger.api.models

import com.ioki.passenger.api.internal.utils.createJson
import kotlin.test.assertEquals

internal abstract class IokiApiModelTest {
    inline fun <reified T : Any> testJsonStringCanBeConvertedToModel(expectedModel: T, jsonString: String) {
        val fromJson = createJson().decodeFromString<T>(jsonString)
        assertEquals(expected = expectedModel, actual = fromJson)
    }

    inline fun <reified T : Any> testModelCanBeConvertedToJsonString(expectedJsonString: String, model: T) {
        val json = createJson().encodeToString(model)
        assertEquals(expected = expectedJsonString.normalize, actual = json)
    }

    private val String.normalize: String get() = replace("\\s+".toRegex(), "")
}
