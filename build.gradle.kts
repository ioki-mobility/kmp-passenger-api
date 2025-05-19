plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.nmcpAggregation)
}

allprojects.forEach {
    it.group = "com.ioki"
    it.version = "0.9.0"
}

nmcpAggregation {
    centralPortal {
        username = providers.systemProperty("SONATYPE_USER")
        password = providers.systemProperty("SONATYPE_PASSWORD")
        publishingType = "USER_MANAGED"
    }

    publishAllProjectsProbablyBreakingProjectIsolation()
}
