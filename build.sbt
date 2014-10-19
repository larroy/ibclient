import AssemblyKeys._

assemblySettings

org.scalastyle.sbt.ScalastylePlugin.Settings

name := "trabot"

version := "0.1"

organization := "com.larroy"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

// stackoverflow.com/questions/24310889/how-to-redirect-aws-sdk-logging-output
resolvers += "version99 Empty loggers" at "http://version99.qos.ch"

libraryDependencies ++= {
  Seq(
    "org.specs2" %% "specs2" % "2.3.12" % "test",
    "com.github.seratch" %% "awscala" % "0.2.+" excludeAll(ExclusionRule(organization= "org.apache.commons.logging")),
    "com.github.scopt" %% "scopt" % "3.2.0",
    "org.slf4j" % "jcl-over-slf4j" % "1.7.7",
    "commons-logging" % "commons-logging" % "99-empty",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "commons-codec" % "commons-codec" % "1.9",
    "org.apache.commons" % "commons-lang3" % "3.3.2",
    "com.netaporter" %% "scala-uri" % "0.4.2",
    "io.argonaut" %% "argonaut" % "6.0.4"
  )
}

resolvers += Resolver.sonatypeRepo("public")

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "console", "junitxml")