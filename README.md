# REST Assured API Automation Framework

## Project Overview
This project demonstrates API automation testing using Java, REST Assured, TestNG, and Maven.  
It validates CRUD operations on ReqRes API endpoints with reusable request specifications, API key authentication, logging, assertions, negative testing, and Maven Surefire reports.

## Tech Stack
- Java
- REST Assured
- TestNG
- Maven
- Git & GitHub
- Maven Surefire Reports

## Key Features
- Reusable `BaseTest` class for common setup
- API key authentication using `x-api-key`
- Config-driven setup using `config.properties`
- Positive test scenarios for GET, POST, PUT, and DELETE
- Negative testing for invalid endpoint and unauthorized access
- Request and response logging for debugging
- Maven Surefire report generation
- Clean GitHub structure with ignored build artifacts

## Project Structure

```text
restassured-api-automation-framework
├── src
│   └── test
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   └── tests
│       │       └── UserApiTest.java
│       └── resources
│           └── config
│               └── config.properties.example
├── reports
│   └── emailable-report.html
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md


