plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin) //targeting Android
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin) // using Compose Multiplatform
    compileOnly(libs.compose.gradlePlugin) // using Compose Multiplatform

}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform"){
            id = "convention.kotlinMultiplatform"
            implementationClass = "KotlinMultiplatformPlugin"
        }
        register("composeMultiplatform"){
            id = "convention.composeMultiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }
//        register("dataModule"){
//            id = "convention.dataModulePlugin"
//            implementationClass = "DataModulePlugin"
//        }
//        register("domainModule"){
//            id = "convention.DomainModulePlugin"
//            implementationClass = "DomainModulePlugin"
//        }
    }


}