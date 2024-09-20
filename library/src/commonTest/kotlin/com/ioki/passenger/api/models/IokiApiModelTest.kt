package com.ioki.passenger.api.models

import com.ioki.passenger.api.internal.utils.createJson
import kotlin.test.expect

internal abstract class IokiApiModelTest {
    inline fun <reified T : Any> testSerializationWithJsonString(model: T, jsonString: String) {
        val fromJson = createJson().decodeFromString<T>(jsonString)
        expect(model) { fromJson }
    }
}
