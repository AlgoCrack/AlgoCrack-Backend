# AlgoCrack

## Introduction
AlgoCrack is a cheating website that imitates leetcode.

## Feature
- Google Oauth login
- Crawling leetcode questions
- Use code runner to execute code
- Share solutions with others
- Get answers from ChatGPT

## Architecture
![image](https://private-user-images.githubusercontent.com/80031876/345651790-f79e46a8-a6af-4d88-85b0-ca8d1dc6a3ee.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MjAyOTYyOTEsIm5iZiI6MTcyMDI5NTk5MSwicGF0aCI6Ii84MDAzMTg3Ni8zNDU2NTE3OTAtZjc5ZTQ2YTgtYTZhZi00ZDg4LTg1YjAtY2E4ZDFkYzZhM2VlLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA3MDYlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNzA2VDE5NTk1MVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTQ5NzdhOGUyNTk4Yjc3YWQ2ZDFmMGI1MDYyNTM5OTg0ZjU4Y2E4NDhmZDg1ODg3YjlmZmEyNDFlNDAxZWFiY2EmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.txNsciLrqgdP6k64Va_tPHpsxJP6trBzzdIFrVWLqnc)

## Setting environment part
Before you begin, make sure your development environment includes the following tools and software:
- Java Development Kit (JDK): JDK 17 or newer is recommended.
- Apache Maven: Used to build and manage project dependencies.
- Visual Studio Code：Used for editing code and debugging.
- Postgres: Used as database

## Build Project
```bash
mvn package
```

## run Project
```bash
mvn spring-boot:run
```

## Debug Mode
use vscode built-in debug mode.

## Lint check
Use VS Code’s EditorConfig extension for lint checking

please use vscode extension => "EditorConfig for VS Code"

## CLI Lint check
Run the following command to perform a Checkstyle check:
```bash
mvn checkstyle:check
```

## unit test
It will generate a coverage report at /target/site/jacoco/index.html
``` bash
mvn clean test
```

## swagger
Access the Swagger UI to view and test API endpoints:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Eureka
The Eureka server is used as a service registration center

[http://localhost:8761](http://localhost:8761)
