@ECHO off

CALL compile.cmd

set DEST=%*
Copy target\chat-0.0.1.jar %DEST%