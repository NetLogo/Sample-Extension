enablePlugins(org.nlogo.build.NetLogoExtension)

name := "sample"
version := "1.2.0"
isSnapshot := true

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii", "--release", "11")

scalaVersion := "3.7.0"
Test / scalaSource := baseDirectory.value / "src" / "test"
scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-feature", "-encoding", "us-ascii", "-release", "11")

netLogoVersion      := "7.0.0-beta2-8cd3e65"
netLogoClassManager := "SampleExtension"
