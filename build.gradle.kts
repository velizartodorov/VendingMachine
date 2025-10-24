import org.gradle.jvm.toolchain.JavaLanguageVersion.of
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.2.21"
    application
    jacoco
}

group = "me.pc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.0")
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
}

java {
    toolchain {
        languageVersion.set(of(21))
    }
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
    }
}

tasks.jacocoTestReport {
    reports {
        csv.required.set(true)
    }
}

application {
    mainClass.set("MainKt")
}