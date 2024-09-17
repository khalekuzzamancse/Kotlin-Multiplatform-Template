plugins {
    alias(libs.plugins.convention.composeMultiplatfrom)
}

kotlin {
    sourceSets{
        val commonMain by getting{
            dependencies {
                implementation(projects.common.ui)

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