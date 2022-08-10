enablePlugins(org.nlogo.build.NetLogoExtension)

name := "sample"
version := "1.1.1"
isSnapshot := true

javaSource in Compile := baseDirectory.value / "src" / "main"
javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path", "-encoding", "us-ascii", "--release", "11")

scalaVersion := "2.12.12"
scalaSource in Test := baseDirectory.value / "src" / "test"
scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-feature", "-encoding", "us-ascii", "-release", "11")

netLogoVersion := "6.2.2"
netLogoClassManager := "SampleExtension"
