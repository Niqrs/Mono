plugins {
    id("android-setup")
    id("compose-setup")
}

android {
    namespace = ProjectConfig.namespace("settings.ui")
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":settings:domain"))
}