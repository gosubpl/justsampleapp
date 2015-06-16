import sbt.Keys._
import sbt._

//import org.apache.commons.io.FileUtils

object BuildSettings {

  import Dependencies._

  //import com.earldouglas.xsbtwebplugin.PluginKeys._ // what for?

  val packageDist = TaskKey[Unit]("package-dist")
  val dist = TaskKey[Unit]("dist") // etc.

  val jsaBuildSettings: Seq[Setting[_]] = Defaults.coreDefaultSettings ++ Seq[Setting[_]](
    //testFrameworks += new TestFramework("..."),
    organization := "pl.gosub",
    //version := buildVersion,
    scalaVersion := _scalaVersion,
    scalacOptions := Seq("-language", "-deprecation", "-unchecked"),
    parallelExecution := true,
    parallelExecution in Test := true,
    //        resolvers := Resolvers.all
    libraryDependencies ++= akka ++ testing ++ slick ++ lift ++ oneOff,

    javaOptions ++= Seq("-Xmx1G", "-server"),


    packageDist <<= (baseDirectory, target) map {
      (theBase, targetDir) =>
        val start = System.currentTimeMillis()
        //delete(targetDir / "dist")
        //copyDirectory(theBase / "distribution" / "content", targetDir / "dist")
        //copyFile(theBase / "distribution" / "deploy.sh", targetDir/ "dist" / "deploy.sh")

        //val files = (targetDir / "dist") ** .... costam
        //val mappings = files pair relaviteTo(targetDir / "dist")
        //zip(mappings, targetDir / "dist.zip")
        val finish = System.currentTimeMillis()
        println("packageDist duration " + (finish - start))
    }) ++ com.earldouglas.xwp.XwpPlugin.jetty()

  //        dist <<= Seq(packageWar in Comopile, packageDist).dependOn
  //        }
}

object jsaBuild extends Build {

  import BuildSettings._

  lazy val app = Project("JSA", file("."))
    .settings(jsaBuildSettings: _*)
}


