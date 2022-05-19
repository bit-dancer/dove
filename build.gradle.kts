plugins {
    id("base")
    id("java")
    id("java-library")
    id("org.springframework.boot") version "2.6.7"
}

allprojects {
    apply(plugin = "base")
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    group = "cn.bitdancer.dove"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
        options.encoding = "UTF-8"
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }

    configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.6.7")
        }
    }
}

subprojects {
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    }

    tasks.withType<Delete> {
        doFirst {
            delete("logs", "out", "build")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
