plugins {
    id("kotlin")
}

dependencies {
    implementation(project(":core:kotlin:coroutines:api"))
    implementation(project(":core:network:api"))
    implementation(project(":core:network:model"))

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.serialization.kotlinx.json)
}
