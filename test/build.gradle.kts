plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

kotlin {
    explicitApi()

    applyDefaultHierarchyTemplate()

    jvmToolchain(17)

    jvm()
    androidTarget {
        publishLibraryVariants("release")
    }
    iosX64()
    iosArm64()
    macosX64()
    macosArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":library"))
            }
        }
    }
}

android {
    namespace = "com.ioki.passenger.api.test"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    buildFeatures {
        buildConfig = true
    }
}

val dokkaJar = tasks.register<Jar>("dokkaJar") {
    dependsOn(tasks.dokkaGenerate)
    from(tasks.dokkaGeneratePublicationHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

group = "com.ioki"
version = "0.3.0-SNAPSHOT"

publishing {
    // Workaround for the Android target
    // withType<MavenPublication> does not work for Android target
    afterEvaluate {
        publications.withType<MavenPublication> {
            artifactId = artifactId.replace("test", "passenger-api-test")
        }
    }
    publications.withType<MavenPublication> {
        artifact(dokkaJar)
        pom {
            name.set("KMP ioki Passenger API")
            description.set("Kotlin Multiplatform ioki Passenger API")
            url.set("https://github.com/ioki-mobility/kmp-passenger-api")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            organization {
                name.set("ioki")
                url.set("https://ioki.com")
            }
            developers {
                developer {
                    id.set("ioki")
                    name.set("ioki Android Team")
                    organization.set("ioki")
                    organizationUrl.set("https://www.ioki.com")
                }
            }
            scm {
                url.set("https://github.com/ioki-mobility/kmp-passenger-api")
                connection.set("scm:git:git://github.com/ioki-mobility/kmp-passenger-api.git")
                developerConnection.set("scm:git:ssh://git@github.com/ioki-mobility/kmp-passenger-api.git")
            }
        }
    }

    repositories {
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") {
            name = "SonatypeSnapshot"
            credentials {
                username = System.getenv("SONATYPE_USER")
                password = System.getenv("SONATYPE_PASSWORD")
            }
        }
        maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
            name = "SonatypeStaging"
            credentials {
                username = System.getenv("SONATYPE_USER")
                password = System.getenv("SONATYPE_PASSWORD")
            }
        }
    }
}

signing {
    val signingKey = System.getenv("GPG_SIGNING_KEY")
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")
    isRequired = hasProperty("GPG_SIGNING_REQUIRED")
    if (isRequired) useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}

// Workaround taken from here:
// https://github.com/gradle/gradle/issues/26091#issuecomment-1722947958
// Maybe fix can be found here:
// https://github.com/gradle/gradle/pull/26292
tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
}
