import com.typesafe.sbt.SbtStartScript

name := "ZapBox"

seq(com.github.siasia.WebPlugin.webSettings :_*)

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.9.1"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )

seq(SbtStartScript.startScriptForClassesSettings: _*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")



libraryDependencies ++= {
  val liftVersion = "2.5-M3"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftmodules"   %% "lift-jquery-module" % (liftVersion + "-2.0"),
    "org.eclipse.jetty" % "jetty-server" % "7.3.1.v20110307" % "compile->default",
    "org.eclipse.jetty" % "jetty-servlet" % "7.3.1.v20110307" % "compile->default",
    "org.eclipse.jetty" % "jetty-webapp"        % "8.1.7.v20120910"  % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.specs2"        %% "specs2"             % "1.12.1"           % "test"
  )
}

