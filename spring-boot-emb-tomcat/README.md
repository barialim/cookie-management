# Spring Boot (Embedded Tomcat)
This service is a SaaS app that runs on embedded tomcat. 

## Getting Started  
### Prerequisites**

* IDEA - Eclipse or IntelliJ 
* Apache Maven => 3.5.2
* Java => 1.8

### Build
```mvn clean package```

### Run tests
```mvn test``` or ```mvn -DskipTests=false clean package```

### Run app

To execute a publication application packaged as a fat jar

```java -jar target/spring-boot-emb-tomcat-1.0.0-SNAPSHOT.jar nohup &```

### REST API specification 

##### Base API - ```spike/```

| Name  | Method | URL Params | Body | Authentication | Description |
| --- | --- | --- | --- | --- | --- | 
| /info| GET | `Required: No` | `No` | `No` |Show application info like name and version |  

##### Curl Commands 

> - **/info** ```curl -i -X GET 'http://localhost:8443/spike/info'```

## Swagger Documentation
http://localhost:8443/spike/swagger-ui.html 