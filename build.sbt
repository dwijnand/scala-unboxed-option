// shadow sbt-scalajs' crossProject and CrossType from Scala.js 0.6.x
import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

crossScalaVersions in ThisBuild := Seq("0.21.0-RC1", "2.12.8", "2.11.12")
scalaVersion in ThisBuild := crossScalaVersions.value.head

lazy val `scala-unboxed-option` = crossProject(JSPlatform, JVMPlatform).
  crossType(CrossType.Pure).
  in(file(".")).
  settings(
    name := "scala-unboxed-option",
    version := "0.1-SNAPSHOT",
    organization := "be.doeraene",
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-Xfatal-warnings",
      "-encoding", "utf8"
    ),

    libraryDependencies += "com.eed3si9n.verify" %%% "verify" % "0.2.0" % Test,
    scalacOptions in Test -= "-Xfatal-warnings"
  )
