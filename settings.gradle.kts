pluginManagement {
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
    versionCatalogs {
        create("localModules") {
            from(files("gradle/localModules.versions.toml"))
        }
    }
}

rootProject.name = "CMPTemplate"
val applications= listOf(":applications",":applications:android",":applications:desktop")
val coreModules= listOf(":core",":core:network",":core:di",":core:database")
val uiLayers=listOf(":layer","layer:ui","layer:ui:common_ui")
val domainLayers=listOf(":layer:domain")
val dataLayers=listOf(":layer:data")
val feature=listOf(":feature",":feature:navigation")

val allModules=applications+coreModules+uiLayers+domainLayers+dataLayers+feature
include(allModules)

