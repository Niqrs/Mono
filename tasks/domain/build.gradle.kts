plugins {
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("tasks.domain")
}

dependencies {
    api(project(":core:utils"))
}