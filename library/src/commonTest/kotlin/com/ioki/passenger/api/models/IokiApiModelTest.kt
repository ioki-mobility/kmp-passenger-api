package com.ioki.passenger.api.models

import com.ioki.passenger.api.internal.utils.createJson
import io.kotest.matchers.shouldBe

internal abstract class IokiApiModelTest {
    inline fun <reified T : Any> testJsonStringCanBeConvertedToModel(expectedModel: T, jsonString: String) {
        val fromJson = createJson().decodeFromString<T>(jsonString)
        fromJson shouldBe expectedModel
    }

    inline fun <reified T : Any> testModelCanBeConvertedToJsonString(expectedJsonString: String, model: T) {
        val json = createJson().encodeToString(model)
        json shouldBe expectedJsonString.normalize
    }

    private val String.normalize: String get() = replace("\\s+".toRegex(), "")
}
