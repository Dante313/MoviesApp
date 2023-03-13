package com.example.convention

object Libs {

    object Gradle {
        const val androidPlugin = "com.android.tools.build:gradle:7.4.2"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0"
    }

    object Compose {
        const val version = "1.3.3"

        const val ui = "androidx.compose.ui:ui:$version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material3 = "androidx.compose.material3:material3:1.1.0-alpha08"
        const val activity = "androidx.activity:activity-compose:1.6.1"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }
}