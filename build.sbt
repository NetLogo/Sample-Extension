enablePlugins(org.nlogo.build.NetLogoExtension)

name := "sample"

version := "1.1.1"

netLogoClassManager := "SampleExtension"

netLogoZipSources   := false

javaSource in Compile := baseDirectory.value / "src"

javacOptions ++= Seq("-g", "-deprecation", "-Xlint:all", "-Xlint:-serial", "-Xlint:-path",
  "-encoding", "us-ascii")

// The remainder of this file is for options specific to bundled netlogo extensions
// if copying this extension to build your own, it may be best to delete
// everything below line 14
netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

resolvers      += "netlogo" at "https://dl.cloudsmith.io/public/netlogo/netlogo/maven/"
netLogoVersion := "6.2.0-d27b502"
