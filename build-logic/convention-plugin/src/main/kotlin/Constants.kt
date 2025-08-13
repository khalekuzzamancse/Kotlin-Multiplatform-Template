@file:Suppress("UnUsed")

import org.gradle.api.JavaVersion

object Constants {
    const val COMPILE_SDK = 34
    const val MIN_SDK = 24
    val SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
    val TARGET_SOURCE_COMPATIBILITY = JavaVersion.VERSION_17
    const val JVM_TARGET="17"
    const val KOTLIN_COMPILER_EXTENSION_VERSION="1.5.13"
    const val KMP_PLUGIN_ID="org.jetbrains.kotlin.multiplatform"
    const val ANDROID_LIBRARY_PLUGIN_ID="com.android.library"
    const val CMP_PLUGIN_ID="org.jetbrains.compose"
    const val COMPOSE_COMPILER_PLUGIN_ID="org.jetbrains.kotlin.plugin.compose";


}