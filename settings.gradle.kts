/**
 * Type-Safe Project Accessors, a feature introduced in Gradle 7.0 that allows you to reference project dependencies
 * in a type-safe manner without relying on string-based project paths like project(":x") as implement(projects.x)
 */
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
   includeBuild("build-logic")//build-logic as a Composite Build, for convention plugin

    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

val applicationModules = listOf(
    ":applications",
   ":applications:android",
    ":applications:desktop",
    ":applications:web",
)


val coreModules = listOf(
    ":core",
)


val featuresModules = listOf(
    ":feature",
    ":feature:web-support",
    ":feature:navigation",

)

include(applicationModules+coreModules+featuresModules)
