REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.core.server\target\base.core.server-1.3.0-SNAPSHOT.jar;base.core.server\target\dependency\*;

REM call the java VM, e.g, 
java -cp %BASE_CP% eapli.base.server.FluxEngine
