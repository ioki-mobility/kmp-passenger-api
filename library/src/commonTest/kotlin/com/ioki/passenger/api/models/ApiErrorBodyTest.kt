package com.ioki.passenger.api.models

import kotlin.test.Test

internal class ApiErrorBodyTest : IokiApiModelTest() {
    @Test
    fun serialization() {
        testJsonStringCanBeConvertedToModel(
            ApiErrorBody(
                listOf(
                    ApiErrorBody.ApiError(
                        message = "We think your first name is no good",
                        code = "we_think_first_name_is_not_good",
                    ),
                    ApiErrorBody.ApiError(
                        message = "There are problems with your last name",
                        code = "there_are_last_name_problems",
                    ),
                ),
            ),
            errorBody,
        )
    }

    @Test
    fun serializationMinimal() {
        testJsonStringCanBeConvertedToModel(
            ApiErrorBody(),
            errorBodyMinimal,
        )
    }
}

private val errorBody =
    """
{
  "api_errors": [
    {
      "message": "We think your first name is no good",
      "code": "we_think_first_name_is_not_good"
    },
    {
      "message": "There are problems with your last name",
      "code": "there_are_last_name_problems"
    }
  ]
}
"""

private val errorBodyMinimal =
    """
{
  "api_errors": []
}
"""
