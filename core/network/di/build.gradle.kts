plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(project(":core:kotlin:coroutines:api"))
    implementation(project(":core:network:api"))
    implementation(project(":core:network:main"))

    implementation(libs.dagger.hilt.core)
    kapt(libs.dagger.hilt.compiler)
}