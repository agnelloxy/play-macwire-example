name := "my-macwire-example"

version := "1.0"

scalaVersion := "2.11.8"

//@see http://www.scala-sbt.org/0.13/docs/ja/Basic-Def.html
lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

libraryDependencies += "com.typesafe.play" %% "play-slick" % "3.0.0"
libraryDependencies += "com.h2database" % "h2" % "1.3.176"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.8.47" % "test"
libraryDependencies += jdbc
libraryDependencies += "com.github.tototoshi" %% "slick-joda-mapper" % "2.3.0"
libraryDependencies += "joda-time" % "joda-time" % "2.7"
libraryDependencies += "org.joda" % "joda-convert" % "1.7"
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
libraryDependencies += "org.flywaydb" %% "flyway-play" % "4.0.0"
