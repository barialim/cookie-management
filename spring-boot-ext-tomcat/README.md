# Spring Boot App Runs on External Tomcat
Repository for tracking changes for spring boot application running on external tomcat.

## Prerequisites

- JRE `v1.8`
- Apache Tomcat `>=v8.5`

## Getting started
- Build project `mvn clean package`
- Copy the generated `.war` file onto `tomcat\webapp` directory
- Run `./bin/catalina.bat run`
- Goto `http://localhost:8080/spike/info`
