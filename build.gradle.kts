plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "back.to"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation ("org.jetbrains.kotlin:kotlin-test")
    testImplementation("junit:junit:4.13.2")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}