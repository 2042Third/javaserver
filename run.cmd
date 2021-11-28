@echo off

cd target
javac -cp chat-0.0.1.jar;.\*;. Main.java
java -cp chat-0.0.1.jar;.\*;. Main
cd ../
