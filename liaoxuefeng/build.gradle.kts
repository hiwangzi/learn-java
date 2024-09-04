description = "liaoxuefeng"

plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    runtimeOnly(libs.mysql.mysql.connector.java)
    testImplementation(libs.org.junit.jupiter.junit.jupiter.x1)
}

