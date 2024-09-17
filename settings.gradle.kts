pluginManagement {
    includeBuild("build-logic")//build-logic as a Composite Build, for convention plugin
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

}


/*
 * Type-Safe Project Accessors, a feature introduced in Gradle 7.0 that allows you to reference project dependencies
 * in a type-safe manner without relying on string-based project paths like project(":x") as implement(projects.x)
 */
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "CMPTemplate"
val applications= listOf(":applications",":applications:android",":applications:desktop")
val coreModules= listOf(":core",":core:network",":core:database")
val uiLayers=listOf(":common",":common:ui",":common:misc")
val feature=listOf(":feature",":feature:navigation")

val allModules=applications+coreModules+uiLayers+feature
include(allModules)

