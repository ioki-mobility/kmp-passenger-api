plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
}

subprojects.forEach {
    it.group = "com.ioki"
    it.version = "0.6.0"
}

