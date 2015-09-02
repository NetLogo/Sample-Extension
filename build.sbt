scalaVersion := "2.11.7"

enablePlugins(org.nlogo.build.NetLogoExtension)

scalaSource in Compile := baseDirectory.value / "src"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xfatal-warnings", "-encoding", "us-ascii")

netLogoExtName      := "sample"

netLogoClassManager := "SampleExtension"

netLogoZipSources   := false

// The remainder of this file is for options specific to bundled netlogo extensions
// if copying this extension to build your own, it would be best to delete// everything below line 14
val netLogoJarOrDependency =
  Option(System.getProperty("netlogo.jar.url"))
    .orElse(Some("http://ccl.northwestern.edu/netlogo/5.3.0/NetLogo.jar"))
    .map { url =>
      import java.io.File
      import java.net.URI
      if (url.startsWith("file:"))
        (Seq(new File(new URI(url))), Seq())
      else
        (Seq(), Seq("org.nlogo" % "NetLogo" % "5.3.0" from url))
    }.get

unmanagedJars in Compile ++= netLogoJarOrDependency._1

libraryDependencies      ++= netLogoJarOrDependency._2

packageBin in Compile := {
  val jar = (packageBin in Compile).value
  val sampleZip = baseDirectory.value / "sample.zip"
  if (sampleZip.exists) {
    IO.unzip(sampleZip, baseDirectory.value)
    for (jar <- (baseDirectory.value / "sample" ** "*.jar").get)
      IO.copyFile(jar, baseDirectory.value / jar.getName)
    IO.delete(baseDirectory.value / "sample")
  }
  jar
}
