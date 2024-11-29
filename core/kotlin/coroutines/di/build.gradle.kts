plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(project(":core:kotlin:coroutines:api"))
    implementation(project(":core:kotlin:coroutines:main"))

    implementation(libs.dagger.hilt.core)
    kapt(libs.dagger.hilt.compiler)
}