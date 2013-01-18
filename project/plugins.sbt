resolvers += Resolver.url("sbt-plugin-releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)

libraryDependencies += Defaults.sbtPluginExtra("com.typesafe.sbt" %% "sbt-pgp" % "0.7","0.12","2.9.2")

