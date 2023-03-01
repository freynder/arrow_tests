plugins {
    kotlin("jvm") version "1.8.10"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.arrow-kt:arrow-core:1.1.6-alpha.36")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            useKotlinTest()
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("my.kotlin.tests.MainKt")
}
