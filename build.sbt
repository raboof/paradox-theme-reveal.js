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
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "sbt-paradox-reveal.js",
    organization := "net.bzzt",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),

    sbtPlugin := true,
    addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.3.2"),

    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "net.bzzt.paradox.reveal.js",

    publishMavenStyle := false,
    bintrayRepository := "sbt-plugins",
  )
