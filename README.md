# KMP Passenger API

[![Maven Central](https://img.shields.io/maven-central/v/com.ioki/passenger-api?labelColor=%2324292E&color=%233246c8)](https://central.sonatype.com/artifact/com.ioki/passenger-api)
<!-- Badge because of https://github.com/badges/shields/pull/10997
[![Snapshot](https://img.shields.io/nexus/s/com.ioki/passenger-api?labelColor=%2324292E&color=%234f78ff&server=https://central.sonatype.com/repository/maven-snapshots/)](https://central.sonatype.com/service/rest/repository/browse/maven-snapshots/com/ioki/passenger-api/)
-->

## Overview

The KMP Passenger API Library is an open-source Kotlin Multiplatform project
designed to provide a comprehensive suite of models and classes for interacting with the ioki passenger APIs.

Currenly supported platforms:
* Apple (iOS, macOS)
* JVM
* Android

## Features

- **Multiplatform Support**: Leverage the power of Kotlin Multiplatform to run your API interactions on any device.
- **Comprehensive Models**: Includes a wide range of pre-defined models for passenger data, making API requests simpler and more intuitive.
- **Easy API Requests**: Simplified classes and functions for making API requests, handling responses, and managing errors.
- **Open Source**: Freely available for use and contribution, fostering community improvements and enhancements.

## Getting Started

To include the KMP Passenger API Library in your project, add the following dependency to your `build.gradle.kts` file:
```kotlin
// Ensure you have the Kotlin Multiplatform plugin applied to your project
plugins {
    kotlin("multiplatform")
}

// The library is hosted on mavenCentral
repositories {
    mavenCentral()
}

val commonMain by getting {
    dependencies {
        implementation("com.ioki:passenger-api:$currentVersion")
    }
}
```

<details>
    <summary>Snapshots of the development version are available in Sonatype's snapshots repository.</summary>

```kotlin
repositories {
    maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
}

val commonMain by getting {
    dependencies {
        implementation("com.ioki:passenger-api:$currentSnapshotVersion")
    }
}
```
</details>

## Usage

After including the library in your project, you first have to create an instance of the `IokiService` like the following:
```kotlin
val iokiService: IokiService = IokiService(
    baseUrl: String = "https://**.io.ki"
    requestHeaders: RequestHeaders = RequestHeaders(**)
    accessTokenProvider: AccessTokenProvider = InMemoryAccessTokenProvider()
    incerceptors: Set<ApiErrorInterceptor> = setOf() // Optional
    timeOffsetProvider: TimeOffsetProvider = NoopTimeOffsetProvider // Optional
    logging: Logging? = { println(it) } // Optional
)
```

After that, you can communicate with it to make API calls:
```kotlin
val phoneNumber = ""
val request = ApiPhoneVerificationRequest(phoneNumber, null)
val phoneVerificationResult = iokiService.requestPhoneVerification(request)
```

The results of the API calls are wrapped into an [`ApiResult`](library/src/commonMain/kotlin/com/ioki/passenger/api/result/Result.kt) class.
Which is just a small wrapper around [`ioki-mobility/Result`](https://github.com/ioki-mobility/Result).
A basic usage could look like this:
```kotlin
when(phoneVerificationResult) {
    is Result.Success -> { /* Do somehing with the success ${phoneVerificationResult.value} */ }
    is Result.Error -> {
        // Do somehing with the error ${phoneVerificationResult.error}.
        // This error is one of the sub types `Api`, `Generic`, and `Connectivity`
    }
}
```

However, there are more functions on `Result` like `map`, `successOrHandle`, `mapFailure`, etc.
Checkout the [`ioki-mobility/Result`](https://github.com/ioki-mobility/Result) documentation to find out more.

## Test artifact

This project provides a test artifact that can be used as a test dependency in your project.
The test artifacts provide default implementations for the `Services` to easily create fakes for your tests. You can simply override the functions relevant for you and ignore the rest.
```kotlin
val fakeUserService = object : UserServiceFake() {
    // Only override what you need
    override suspend fun deleteUser(): ApiResult<Unit> = Result.Success(SuccessData(Unit))
}
```

Additionally, it provides helper functions to create APIObjects easily.
```kotlin
val rideResponse = createApiRideResponse()
```

Those match well with your tests:
```kotlin
val fakeCurrentRideService = object : FakeCurrentRideService() {
    override suspend fun getCurrentRide(): ApiResult<ApiRideResponse> = Result.Success(SuccessData(
        createApiRideResponse(
            version = 1,
            pickup = createApiLocation(
                latitude = 50.1174225,
                longitude = 8.668939,
            ),
            dropoff = createApiLocation(
                latitude = 50.109694,
                longitude = 8.6666095,
            ),
        )
    ))
}

ClassUnderTest(fakeCurrentRideService)
```

To include it in your project, add the following dependency to your `build.gradle.kts` file:
```kotlin
val commonTest by getting {
    dependencies {
        implementation("com.ioki:passenger-api-test:$currentVersion")
    }
}
```

## Contribute
### Don't forget about local.properties

If you see this issue:

```
* What went wrong:
Could not determine the dependencies of task ':library:testDebugUnitTest'.
> SDK location not found. Define a valid SDK location with an ANDROID_HOME environment variable or by setting the sdk.dir path in your project's local properties file at '/Users/***/kmp-passenger-api/local.properties'.
```

Please provide the path to your Android SDK in the `local.properties` file in the root of the project. For example:

```
sdk.dir=/Users/***/Library/Android/sdk
```

## Release
Checkout the [`RELEASE.md`](RELEASE.md) file to see how to create a new release.

## License

This project is licensed under the MIT License - see the [`LICENSE` file](LICENSE) for details.
