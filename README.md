# AlgoCrack

## Introduction
AlgoCrack is a cheating website that imitates leetcode.

## Feature
- Google Oauth login
- Upload questions
- Use code runner to execute code
- Share solutions with others
- Get answers from ChatGPT

## Architecture
![image](https://github.com/emberow/blog-image/blob/main/BlogImg/AlgoCrack%E6%9E%B6%E6%A7%8B.png?raw=true)

## Project Management
https://github.com/orgs/AlgoCrack/projects/5

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
