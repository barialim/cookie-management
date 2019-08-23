# Cookie Management
This service is a SaaS app that runs on embedded tomcat shows a cookie management example. 

Cookies are generally used for:
*	Session management
*	User-tracking
*	To store user preferences

Cookies help server remember the client across multiple requests. 
Without cookies, the server would treat every request as a new client.

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

```java -jar target/cookie-management-1.0.0-SNAPSHOT.jar nohup &```

### REST API specification 

##### Base API - ```spike/```

| Name  | Method | URL Params | Body | Authentication | Description |
| --- | --- | --- | --- | --- | --- | 
| /info| GET | `Required: No` | `No` | `No` |Show application info like name and version |  

##### Curl Commands 

> - **/info** ```curl -i -X GET 'http://localhost:8444/spike/info'```

## Swagger Documentation
http://localhost:8444/spike/swagger-ui.html 

## Sequence Diagram ##
![alt text](../etc/docs/images/cookie-management-sequence-diagram.png "Cookie Management Sequence Diagram")
