plugins {
    alias(libs.plugins.convention.composeMultiplatfrom)
}
kotlin {
    sourceSets{
        val commonMain by getting{
            dependencies {
                implementation(libs.bundles.ktorClient)
                implementation(libs.bundles.coil)
            }
        }
    }

}
android {
    namespace = "common_ui"
}
