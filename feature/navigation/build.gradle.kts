plugins {
    alias(libs.plugins.convention.composeMultiplatfrom)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    sourceSets{
        val commonMain by getting{
            dependencies {
                implementation(projects.common.ui)
                implementation(libs.common.navigation)
                implementation(libs.common.viewmodel)
            }
        }
        val androidMain by getting{
            dependencies {


            }
        }
        val desktopMain by getting{
            dependencies {

            }
        }
    }



}
android {
    namespace = "navigation"
}