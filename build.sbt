organization := "com.github.sassunt"

name := "scalor"

crossScalaVersions := Seq("2.9.2","2.10.0")

version := "0.1.0"

libraryDependencies <+= scalaVersion( {
  case "2.10.0" => "org.specs2" %% "specs2" % "1.13" % "test"
  case _ => "org.specs2" %% "specs2" % "1.12.2" % "test"
  }
)

