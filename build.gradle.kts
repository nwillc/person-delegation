import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val assertJVersion: String by project
val jupiterVersion: String by project

plugins {
    kotlin("jvm") version "1.3.41"
    id("com.github.nwillc.vplugin") version "3.0.1"
}

group = "com.github.nwillc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
    testImplementation("com.google.code.gson:gson:2.8.5")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    withType<Test> {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
        beforeTest(KotlinClosure1<TestDescriptor, Unit>({ logger.lifecycle("  Should ${this.name}") }))
        afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ descriptor, result ->
            if (descriptor.parent == null) {
                logger.lifecycle("\nTests run: ${result.testCount}, Failures: ${result.failedTestCount}, Skipped: ${result.skippedTestCount}")
            }
            Unit
        }))
    }
}
