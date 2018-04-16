gradlew build
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:startbrowser
if "%ERRORLEVEL%" == "0" goto enterwebpage
echo Cannot start a browser!
goto fail

:enterwebpage
start "" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot run the webpage!
goto fail

:fail
echo.
echo There were errors...

:end
echo.
echo Work is finished.