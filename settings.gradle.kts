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

include(":tasks:data")
include(":tasks:ui")
include(":tasks:domain")

include(":settings:data")
include(":settings:ui")
include(":settings:domain")
