@echo off
setlocal

:: Set your URL and JSON data here
set "URL=http://localhost:8080/api/products"
set "PRODUCT_URL=http://localhost:8080/api/products/3"

set "JSON={\"name\":\"Smartphone\",\"brand\":\"Samsung\",\"price\":599.99,\"stock\":100,\"description\":\"A high-quality smartphone with advanced features.\"}"
echo %JSON%

echo.
echo.
echo.

:: GET request
echo Sending GET request...
curl -i -X GET "%URL%" 
echo.
echo.
echo.

:: POST request
echo Sending POST request...
curl -i -X POST -H "Content-Type: application/json" -d "%JSON%" "%URL%"
echo.
echo.
echo.

:: GET request
echo Sending GET request...
curl -i -X GET "%PRODUCT_URL%"
echo.
echo.
echo.

:: PUT request
echo Sending PUT request...
curl -i -X PUT -H "Content-Type: application/json" -d "%JSON%" "%PRODUCT_URL%"
echo.
echo.
echo.

:: DELETE request
echo Sending DELETE request...
curl -i -X DELETE "%PRODUCT_URL%"
echo.
echo.
echo.

endlocal
