@echo off
setlocal

:: Set your URL and JSON data here
set "URL=http://localhost:8080/api/k8s-demo"

:: GET request
echo Sending GET request...
curl -i -X GET "%URL%" 

endlocal
