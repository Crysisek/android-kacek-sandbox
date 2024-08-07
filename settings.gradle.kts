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
include(":core:kotlin:coroutines")
include(":core:kotlin:mapper")
include(":core:network:di")
include(":core:network:main")
include(":core:theme")
include(":data:base-feature")
include(":domain:base-feature")
include(":presentation:base-feature")
include(":ui:base-feature")
