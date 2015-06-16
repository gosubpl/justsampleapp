import sbt._

/*
object Resolvers {
        val all = Seq("...")
        }
*/

object Dependencies {
  val _scalaVersion = "2.11.6"
  private val akkaVersion = "2.3.11"
  private val h2Version = "1.3.176"
  private val scalatestVersion = "2.2.4"
  private val scalazVersion = "7.1.2"
  private val slickVersion = "3.0.0"
  private val liftVersion = "2.6.2"
  private val jettyVersion = "8.1.7.v20120910"
  //private val driveByVersion mockitoVersion liftVersion ...

  val testing = Seq(
    "org.scalatest" % "scalatest_2.11" % scalatestVersion % "test"
  )

  val akka = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  )
  val scalaz = Seq(
    "org.scalaz" %% "scalaz-core" % scalazVersion
  )
  val slick = Seq(
    "com.typesafe.slick" %% "slick" % slickVersion
  )

  val lift = Seq (
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" %% "lift-mapper" % liftVersion
  )

  val oneOff = Seq (
    "org.eclipse.jetty" % "jetty-webapp" % jettyVersion
  )
}

