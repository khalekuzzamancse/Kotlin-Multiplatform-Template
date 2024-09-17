plugins {
    `kotlin-dsl`
}

group = "com.example.app.buildlogic" //your module name

dependencies {
    compileOnly(libs.android.gradlePlugin) //if targetting Android
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin) //if you are using Compose Multiplatform
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform"){
            id = "com.convention.kotlinMultiplatform"
            implementationClass = "KotlinMultiplatformPlugin"
        }
        register("composeMultiplatform"){
            id = "convention.composeMultiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }
    }
}

/**
libs.versions.toml
android-gradlePlugin = { module = "com.android.tools.build:gradle", version.ref = "agp" }
kotlin-gradlePlugin = { module = "org.jetbrains.kotlin:kotlin-gradle-plugin", version.ref = "kotlin" }
compose-gradlePlugin = { module = "org.jetbrains.compose:org.jetbrains.compose.gradle.plugin", version.ref = "compose" }
 **/