resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.7.0-SNAPSHOT")

//Enable the sbt web plugin
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "1.1.0")
