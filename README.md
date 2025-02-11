# currencyconverter
intructions to run code locally

Check Java Installation
Open a terminal or command prompt.
Run the following command:
sh:
java --version
Expected output (Java 17 or later required):

nginx:
java version "17.0.2" 2022-01-18 LTS
If Java is not installed, download it from Adoptium and install it.

Check Maven Installation
Run the following command:
sh:
mvn -version
Expected output:

nginx:
Apache Maven 3.8.4
If Maven is not installed, download it from Maven Apache and install it.

2. Clone the Repository (If applicable)
If project is in a GitHub repository, clone it using:

sh:
git clone <your-repository-url>
Otherwise, navigate to your project folder.

3. Navigate to the Project Directory
sh:
cd currency-converter
4. Configure API URL (Optional)
Open src/main/resources/application.properties and verify the exchange rate API URL:

properties
exchange.api.url=https://api.exchangerate-api.com/v4/latest/
If using a different API, update this URL.

5. Build the Project
Run the following Maven command to compile the project:

sh:
mvn clean package
Expected output:

csharp:
BUILD SUCCESS
6. Run the Spring Boot Application
Option 1: Run with Maven
sh:
mvn spring-boot:run
Option 2: Run the JAR File
If you built the project using mvn package, you can run:

sh:
java -jar target/currency-converter-0.0.1-SNAPSHOT.jar
Expected output:

nginx:
Tomcat started on port 8080
Application started successfully
Your application is now running on http://localhost:8080.

7. Test the API Endpoints
You can test the API using Postman, cURL, or your browser.

Fetch Exchange Rates
Request:
sh:
curl -X GET "http://localhost:8080/api/rates?base=USD"
Response (Example):
json:
{
    "EUR": 0.94,
    "GBP": 0.82,
    "INR": 83.21
}
Convert Currency
Request:
sh:
curl -X POST "http://localhost:8080/api/convert" -H "Content-Type: application/json" -d '{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}'
Response (Example):
json:
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
8. Running Unit Tests
Run unit tests using:

sh:
mvn test
Expected output:

yaml:
Tests run: 1, Failures: 0, Errors: 0
BUILD SUCCESS

9. Stopping the Application
Press CTRL + C in the terminal to stop the server.
