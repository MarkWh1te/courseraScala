#!/bin/sh
mkdir -p src/{main,test}/{java,resources,scala}
mkdir lib project target

# create an initial build.sbt file
echo 'name := "classTest"

version := "1.0"

scalaVersion := "2.11.7"' > build.sbt
