# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/#io.validation)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)


# Development 

## Prerequisites

### Java 17
Install Java Development Kit (JDK): Make sure you have JDK 17 or later installed on your machine. You can download it from the Oracle website or adopt OpenJDK.

### node.js
Install Node.js and npm: Install Node.js and npm (Node Package Manager) to manage the frontend dependencies. You can download Node.js from the official website (https://nodejs.org/).

Install Visual Studio Code: Download and install Visual Studio Code from the official website (https://code.visualstudio.com/).

## Setup

1. Create a directory

2. Clone this git repository into the new directory

3. CD into the cloned repository

4. Start a vscode workspace in this directory (`code .`)

5. Workspace Configuration
    - Install Extensions
        - Debugger for Java  v0.52.0 
        - Maven for Java  v0.41.0 
        - Project Manager for Java  v0.23.0 
        - Spring Boot Tools  v1.47.0
    - Restart vscode after setup has finished

## Application start

### Starting backend

    Run main class `ValidatorApplication.java`

### Starting frontend

    1. In the terminal change to frontend directory `cd frontend`

    2. Run `$env:NODE_OPTIONS = "--openssl-legacy-provider"`

    3. Run `npm start`

## Application test

Tests for frontend in directory frontend/src/App.test.js
Run with `npm test` within /frontend directory

Tests for backend in directory iban-validator/src/test/*
Run with `mvn test` within /iban-validator directory
