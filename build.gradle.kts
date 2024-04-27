plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("me.jakejmattson:DiscordKt:${project.property("discordkt_ver")}")
    implementation("io.github.cdimascio:dotenv-kotlin:${project.property("dotenv_kotlin_ver")}")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}