/* This build script only exists to test this example project. */

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  base
  alias(libs.plugins.pkl)
}

pkl {
  evaluators {
    register("runExample") {
      sourceModules.set(fileTree(projectDir) { include("**/*.pkl") })
      outputFile.set(file("build/out.yaml"))
      projectDir.set(file("."))
    }
  }
}

tasks.check {
  dependsOn(tasks.named("runExample"))
}

