plugins {
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("setting.data")
}

dependencies {
    implementation(project(":core:data"))

    implementation(project(":settings:domain"))

    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.firestore)
    implementation(Dependencies.Firebase.storage)
    implementation(Dependencies.PlayServices.auth)
}