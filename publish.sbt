publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}


resolvers += Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

libraryDependencies += Defaults.sbtPluginExtra("com.typesafe.sbt" %% "sbt-pgp" % "0.7","0.12","2.9.2")

pomExtra := (
  <url>https://github.com/sassunt/scalor</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:sassunt/scalor.git</url>
    <connection>scm:git:git@github.com:sassunt/scalor.git</connection>
  </scm>
  <developers>
    <developer>
      <id>sassunt</id>
      <name>sassunt</name>
      <url>https://github.com/sassunt</url>
    </developer>
    <developer>
      <id>yutagithub</id>
      <name>yutagithub</name>
      <url>https://github.com/yutagithub</url>
    </developer>
    <developer>
      <id>sndyuk</id>
      <name>sndyuk</name>
      <url>https://github.com/sndyuk</url>
    </developer>
  </developers>)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

