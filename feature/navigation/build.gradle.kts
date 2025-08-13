plugins {
    alias(libs.plugins.convention.composeMultiplatfrom)
}
kotlin {
    sourceSets{
        val commonMain by getting{
            dependencies {
                implementation(libs.windowSize)
                implementation(projects.core)
                implementation(libs.common.navigation)

            }
        }


    }


}
android {
    namespace = "navigation"
}
