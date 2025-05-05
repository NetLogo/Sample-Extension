enablePlugins(org.nlogo.build.NetLogoExtension)

name := "sample"
version := "1.1.1"
isSnapshot := true

Compile / javaSource := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii", "--release", "11")

scalaVersion := "2.13.16"
Test / scalaSource := baseDirectory.value / "src" / "test"
scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-feature", "-encoding", "us-ascii", "-release", "11")

netLogoVersion := "7.0.0-internal1-df97144"
netLogoClassManager := "SampleExtension"
