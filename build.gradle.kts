plugins {
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.nmcpAggregation)
}

allprojects.forEach { project ->
    project.group = "com.ioki"
    project.version = buildString {
        append("0.19.0")
        project.findProperty("PRE_RELEASE_IDENTIFIER")?.let {
            append('-')
            append(it)
        }
    }
}

nmcpAggregation {
    centralPortal {
        username = providers.environmentVariable("SONATYPE_USER")
        password = providers.environmentVariable("SONATYPE_PASSWORD")
        publishingType = "USER_MANAGED"
    }

    publishAllProjectsProbablyBreakingProjectIsolation()
}
