name := "akka-http-boilerplate"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= {
  Seq(
      "com.typesafe.akka" %% "akka-http-core" % "2.4.10",
      "com.typesafe.akka" %% "akka-http-experimental" % "2.4.10"
  )
}
