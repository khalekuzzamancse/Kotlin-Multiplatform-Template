import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.convention.composeMultiplatfrom)
}
kotlin {
    js {
        browser()
        useEsModules()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.materialIconsExtended)
                implementation(libs.common.navigation)
            }
        }

    }
    
}
android {
    namespace = "core"
}
