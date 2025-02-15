@REM Script for starting backend server

@echo off
echo --------------------------------------
echo Running SpringBoot Backend Application
echo --------------------------------------

@REM Set the path to the JAR file in a local variable
for /f "delims=" %%i in ('dir "%~dp0\target\timetablemgmt-*.jar" /b /o:-d') do set JAR_PATH=%%i

@REM Run the Spring Boot application
java -jar "%~dp0\target\%JAR_PATH%"