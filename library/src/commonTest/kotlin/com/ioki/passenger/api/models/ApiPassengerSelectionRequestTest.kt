package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiPassengerSelectionRequestTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testSerializationWithJsonString(
            ApiPassengerSelectionRequest(
                type = "adult",
                options =
                    listOf(
                        ApiOption(
                            slug = "wheelchair",
                            value = AnyValue.BooleanValue(false),
                        ),
                        ApiOption(
                            slug = "bahncard",
                            value = AnyValue.BooleanValue(false),
                        ),
                        ApiOption(
                            slug = "walker",
                            value = AnyValue.BooleanValue(true),
                        ),
                        ApiOption(
                            slug = "public_transport_ticket",
                            value = AnyValue.BooleanValue(true),
                        ),
                        ApiOption(
                            slug = "blue_badge",
                            value = AnyValue.BooleanValue(false),
                        ),
                    ),
                firstName = "Spider",
                lastName = "Man",
            ),
            passengerSelectionRequest,
        )
    }

    @Test
    fun serializationMinimal() {
        testSerializationWithJsonString(
            ApiPassengerSelectionRequest(
                type = "child",
                options = listOf(
                    ApiOption(
                        slug = "wheelchair",
                        value = AnyValue.BooleanValue(false),
                    ),
                    ApiOption(
                        slug = "bahncard",
                        value = AnyValue.BooleanValue(false),
                    ),
                    ApiOption(
                        slug = "walker",
                        value = AnyValue.BooleanValue(true),
                    ),
                    ApiOption(
                        slug = "public_transport_ticket",
                        value = AnyValue.BooleanValue(true),
                    ),
                    ApiOption(
                        slug = "blue_badge",
                        value = AnyValue.BooleanValue(false),
                    ),
                ),
                firstName = null,
                lastName = null,
            ),
            passengerSelectionRequestMinimal,
        )
    }

    @Test
    fun deserializationMinimal() {
        testDeserializationWithJsonString(
            passengerSelectionRequestMinimal,
            ApiPassengerSelectionRequest(
                type = "child",
                options = listOf(
                    ApiOption(
                        slug = "wheelchair",
                        value = AnyValue.BooleanValue(false),
                    ),
                    ApiOption(
                        slug = "bahncard",
                        value = AnyValue.BooleanValue(false),
                    ),
                    ApiOption(
                        slug = "walker",
                        value = AnyValue.BooleanValue(true),
                    ),
                    ApiOption(
                        slug = "public_transport_ticket",
                        value = AnyValue.BooleanValue(true),
                    ),
                    ApiOption(
                        slug = "blue_badge",
                        value = AnyValue.BooleanValue(false),
                    ),
                ),
                firstName = null,
                lastName = null,
            ),
        )
    }
}

private val passengerSelectionRequest =
    """
{
	"type": "adult",
    "options": [
      {
        "slug": "wheelchair",
        "value": false
      },
      {
        "slug": "bahncard",
        "value": false
      },
      {
        "slug": "walker",
        "value": true
      },
      {
        "slug": "public_transport_ticket",
        "value": true
      },
      {
        "slug": "blue_badge",
        "value": false
      }
    ],
    "first_name": "Spider",
    "last_name": "Man"
}
"""

private val passengerSelectionRequestMinimal =
    """
{
	"type": "child",
    "options": [
      {
        "slug": "wheelchair",
        "value": false
      },
      {
        "slug": "bahncard",
        "value": false
      },
      {
        "slug": "walker",
        "value": true
      },
      {
        "slug": "public_transport_ticket",
        "value": true
      },
      {
        "slug": "blue_badge",
        "value": false
      }
    ]
}
"""
