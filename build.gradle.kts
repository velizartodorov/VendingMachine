import org.gradle.jvm.toolchain.JavaLanguageVersion.of
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_13
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
    application
    jacoco
}

group = "me.pc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
}

java {
    toolchain {
        languageVersion.set(of(13))
    }
}

kotlin {
    jvmToolchain(13)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JVM_13)
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