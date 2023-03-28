plugins {
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("settings.domain")
}

dependencies {
    api(project(":core:utils"))
}