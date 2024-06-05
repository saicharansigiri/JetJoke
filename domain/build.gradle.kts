plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.detekt)
}

tasks.configureEach {
    if (name == "compileDebugKotlin") {
        dependsOn(tasks.detekt)
        mustRunAfter(tasks.detekt)
    }
}
dependencies {
    implementation(libs.javax.inject)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
