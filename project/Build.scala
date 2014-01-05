import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "hanaroTest"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
	"mysql" % "mysql-connector-java" % "5.1.27"
	// "sqljdbc4" % "com.microsoft.sqlserver" % "3.0"
	// "net.sourceforge.jtds" % "jtds" % "1.3.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
