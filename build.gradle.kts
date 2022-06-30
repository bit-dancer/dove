import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    id("base")
    id("java")
    id("java-library")
}

allprojects {
    apply(plugin = "base")
    apply(plugin = "java")
    apply(plugin = "java-library")

    group = "cn.bitdancer.dove"
    version = "0.0.1-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

subprojects {

    if (!project.name.contains("ui")) {
        dependencies {
            testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
            compileOnly("org.projectlombok:lombok:1.18.24")
            annotationProcessor("org.projectlombok:lombok:1.18.24")
            testCompileOnly("org.projectlombok:lombok:1.18.24")
            testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
        }

        tasks.withType<Test> {
            useJUnitPlatform()
            testLogging {
                events = setOf(PASSED, SKIPPED, FAILED)
            }
        }
    }

    tasks.withType<Delete> {
        doFirst {
            delete("logs", "out", "build")
        }
    }

}
