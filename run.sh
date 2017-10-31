#!/bin/bash

#method 1: run the jar file 
# java -jar FindPoliticalDonors.jar input/input2.txt output/medianvals_by_zip.txt output/medianvals_by_date.txt

#method 2:
javac -cp src/jar/junit-4.12.jar src/com/chenchen/main/*.java
java -cp ./src com.chenchen.main.Main input/itcont.txt output/medianvals_by_zip.txt output/medianvals_by_date.txt