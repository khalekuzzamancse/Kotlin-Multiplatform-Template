plugins {
    alias(libs.plugins.convention.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}
kotlin {

    sourceSets{
        val commonMain by getting{
            dependencies {
                implementation(libs.bundles.ktorClient)//network IO
            }
        }
        val androidMain by getting{
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }
        val desktopMain by getting{
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }
    }


}
android {
    namespace = "network"
   
}