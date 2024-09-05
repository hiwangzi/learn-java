description = "core-java"

plugins {
    id("buildlogic.java-conventions")
}

dependencies {
}

subprojects {
    apply(plugin = "buildlogic.java-conventions")

    dependencies {
        "implementation"(rootProject.libs.slf4j.api)
        "implementation"(rootProject.libs.logback.classic)
        "testImplementation"(rootProject.libs.org.junit.jupiter.junit.jupiter)
    }
}
