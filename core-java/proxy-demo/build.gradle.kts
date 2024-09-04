description = "core-java.proxy-demo"

plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    implementation(libs.slf4j.api)
    implementation(libs.logback.classic)
}

tasks.test {
    useJUnitPlatform()
}
