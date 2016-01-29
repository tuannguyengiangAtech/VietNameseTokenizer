@echo off
cd /d %0\..
java -jar com.vcc.bigdata.tokenizer-1.0.0.jar %*
if NOT "%COMSPEC%" == "%SystemRoot%\system32\cmd.exe" goto end
if %errorlevel% == 9009 echo Java is not in your PATH. Cannot run program.
if errorlevel 1 pause

:end
