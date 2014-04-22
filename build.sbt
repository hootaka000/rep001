import de.johoop.jacoco4sbt._
import JacocoPlugin._

name := "ca-infosys-saiyo"

version := "v0.2"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  filters,
  "com.amazonaws" % "aws-java-sdk" % "1.7.2",
  "mysql" % "mysql-connector-java" % "5.1.30",
  "redis.clients" % "jedis" % "2.4.1",
  "net.arnx" % "jsonic" % "1.3.3",
  "net.glxn" % "qrgen" % "1.3",
  "com.itextpdf" % "itextpdf" % "5.5.0",
  "javax.mail" % "mail" % "1.4.1"
)

play.Project.playJavaSettings

jacoco.settings

jacoco.outputDirectory in jacoco.Config := new File("target/coverage")

jacoco.reportFormats in jacoco.Config := Seq(HTMLReport("utf-8"))

parallelExecution in jacoco.Config := false
