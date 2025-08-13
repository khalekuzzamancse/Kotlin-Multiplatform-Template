
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvm("desktop")
    sourceSets {
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.kotlinx.coroutines.swing)
                implementation(projects.feature.navigation)
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "DesktopMainKt"
        nativeDistributions {
            packageName = "desktopApp"
            version = "1.0.0"
        }
    }
}