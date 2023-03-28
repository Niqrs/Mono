plugins {
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("tasks.data")
}

dependencies {
    implementation(project(":core:data"))

    implementation(project(":tasks:domain"))

    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.firestore)
    implementation(Dependencies.Firebase.storage)
    implementation(Dependencies.PlayServices.auth)
}