plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.nmcpAggregation)
}

allprojects.forEach {
    it.group = "com.ioki"
    it.version = "0.9.0-SNAPSHOT"
}

nmcpAggregation {
    centralPortal {
        username = System.getenv("SONATYPE_USER")
        password = System.getenv("SONATYPE_PASSWORD")
        publishingType = "USER_MANAGED"
    }

    publishAllProjectsProbablyBreakingProjectIsolation()
}
