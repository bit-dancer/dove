plugins {
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val vertxVersion = "4.3.0"

val launcherClassName = "cn.bitdancer.dove.MainLauncher"

application {
    mainClass.set(launcherClassName)
}

dependencies {
    implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
    implementation("io.vertx:vertx-core")
    implementation("io.vertx:vertx-web")
    implementation("io.vertx:vertx-config")
    implementation("io.vertx:vertx-rx-java2")
    implementation("io.vertx:vertx-mongo-client")
    implementation("cn.hutool:hutool-all:5.8.3")
    testImplementation("io.vertx:vertx-junit5")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("fat")
    mergeServiceFiles()
}
