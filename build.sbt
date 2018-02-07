
lazy val theme = project
  .in(file("theme"))
  .enablePlugins(ParadoxThemePlugin)
  .settings(
    name := "paradox-theme-reveal.js",
    organization := "net.bzzt",
  )

lazy val plugin = project
  .in(file("plugin"))
  .settings(
    sbtPlugin := true,
    organization := "net.bzzt",
    name := "sbt-paradox-reveal.js",
    addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.3.2"),
  )
