plugins {
    id("com.github.node-gradle.node") version "3.1.0"
}

val lintTask = tasks.register<com.github.gradle.node.yarn.task.YarnTask>("lintWebapp") {
    dependsOn(tasks.yarn)
    args.addAll("run", "lint")
}

val buildTask = tasks.register<com.github.gradle.node.yarn.task.YarnTask>("buildWebapp") {
    dependsOn(tasks.yarn, lintTask)
    args.addAll("run", "build")
}

var copyTask = tasks.register<Copy>("copyResources") {
    from("dist")
    into("build/resources/main/static")
}

tasks.jar {
    doFirst {
        delete("dist")
    }
    dependsOn(buildTask, copyTask)
}
