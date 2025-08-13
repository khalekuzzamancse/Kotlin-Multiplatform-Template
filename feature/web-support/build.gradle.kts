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
    sourceSets{
        val commonMain by getting{
            dependencies {
             //   implementation(projects.feature.linearDatastructures)
            }
        }
        val jsWasmMain by creating {
            dependsOn(commonMain)
            dependencies {
               // implementation(npm("uuid", "^9.0.1"))
            }
        }

        val jsMain by getting {
            dependsOn(jsWasmMain)
        }

        val wasmJsMain by getting {
            dependsOn(jsWasmMain)
        }

    }


}
android {
    namespace = "web.x"
}
