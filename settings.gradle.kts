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
}

rootProject.name = "Mono"

include(":app")

include(":core:data")
include(":core:ui")
include(":core:utils")

include(":auth:data")
include(":auth:domain")
include(":auth:ui")
