licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

lazy val theme = project
  .in(file("theme"))
  .enablePlugins(ParadoxThemePlugin)
  .settings(
    name := "paradox-theme-reveal.js",
    organization := "net.bzzt",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  )

lazy val plugin = project
  .in(file("plugin"))
  .settings(
    name := "sbt-paradox-reveal.js",
    organization := "net.bzzt",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),

    sbtPlugin := true,
    addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.3.2"),

    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
  )
