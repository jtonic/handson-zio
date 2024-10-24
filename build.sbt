ThisBuild / organization := "handson.zio"
ThisBuild / version := "0.1.0"
ThisBuild / scalaVersion := "3.5.2"
ThisBuild / description := "ZIO hands-on"

lazy val common = (project in file("common"))
  .settings(
    name := "common",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.11",
      "dev.zio" %% "zio-streams" % "2.1.11",
      "dev.zio" %% "zio-test" % "2.1.11" % Test,
      "dev.zio" %% "zio-test-sbt" % "2.1.11" % Test,
      "dev.zio" %% "zio-http" % "3.0.1"
    )
  )

lazy val web = (project in file("web"))
  .settings(
    name := "web",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.11",
      "dev.zio" %% "zio-streams" % "2.1.11",
      "dev.zio" %% "zio-test" % "2.1.11" % Test,
      "dev.zio" %% "zio-test-sbt" % "2.1.11" % Test,
      "dev.zio" %% "zio-http" % "3.0.1"
    )
  )
  .dependsOn(common)

lazy val root = (project in file("."))
  .settings(
    name := "handson-zio"
  )
  .aggregate(common, web)
