plugins {
    id("android-setup")
    id("compose-setup")
}

android {
    namespace = ProjectConfig.namespace("auth.ui")
}

dependencies {
    implementation(project(":core:ui"))
//    implementation(project(":core:data"))
    implementation(project(":core:utils"))

    implementation(project(":auth:domain"))
}