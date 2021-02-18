import sbt.plugins.SbtPlugin

lazy val root = (project in file("."))
  .settings(
    name := "bulky-sources-plugin",
    version := "0.1.0",
  )
  .enablePlugins(SbtPlugin)
