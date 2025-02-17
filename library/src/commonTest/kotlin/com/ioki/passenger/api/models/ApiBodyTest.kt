package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiBodyTest : IokiApiModelTest() {
    @Test
    fun serializationString() {
        testJsonStringCanBeConvertedToModel(
            ApiBody("foobar"),
            apiBodyString,
        )
    }

    @Test
    fun serializationMetaData() {
        testJsonStringCanBeConvertedToModel(
            ApiBody("foobar", ApiBody.Meta(1, true)),
            apiBodyMeta,
        )
    }

    @Test
    fun serializationList() {
        testJsonStringCanBeConvertedToModel(
            ApiBody(listOf("foo", "bar")),
            apiBodyList,
        )
    }

    @Test
    fun serializationNestedLists() {
        testJsonStringCanBeConvertedToModel(
            ApiBody(listOf(listOf("foo", "bar"), listOf("biz", "baz"))),
            apiBodyNestedList,
        )
    }
}

private val apiBodyString =
    """
{
  "data": "foobar"
}
"""

private val apiBodyMeta =
    """
{
  "data": "foobar",
  "meta": {
    "page": 1,
    "last_page": true
  }
}
"""

private val apiBodyList =
    """
{
  "data": [
    "foo",
    "bar"
  ]
}
"""

private val apiBodyNestedList =
    """
{
  "data": [
    [
      "foo",
      "bar"
    ]
  , [
      "biz",
      "baz"
    ]
  ]
}
"""
