plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.nmcpAggregation)
}

allprojects.forEach {
    it.group = "com.ioki"
    it.version = "0.10.0-SNAPSHOT"
}

nmcpAggregation {
    centralPortal {
        username = providers.environmentVariable("SONATYPE_USER")
        password = providers.environmentVariable("SONATYPE_PASSWORD")
        publishingType = "USER_MANAGED"
    }

    publishAllProjectsProbablyBreakingProjectIsolation()
}
