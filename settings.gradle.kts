pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Android-kacek-sandbox"
include(":app")
include(":core")
include(":core:network")
include(":data")
include(":data:base-feature")
include(":domain")
include(":domain:base-feature")
include(":presentation")
include(":presentation:base-feature")
include(":ui")
include(":ui:base-feature")
include(":ui:theme")
include(":core:kotlin")
include(":core:kotlin:mapper")
include(":core:kotlin:coroutines")
