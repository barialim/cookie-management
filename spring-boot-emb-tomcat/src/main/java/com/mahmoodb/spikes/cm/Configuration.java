package com.mahmoodb.spikes.cm;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.context.annotation.Configuration
@EnableSwagger2
public class Configuration {

    /**
     * @return {@link Docket} object for Swagger
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
          .paths(PathSelectors.any())
          .build()
          .genericModelSubstitutes(Optional.class);
    }

    /**
     * @return Custom swagger api documentation information
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Spike (Embedded Tomcat)",
          "API Documentation for Spike Microservice",
          "2.0",
          null,
          new Contact("Spike (Embedded Tomcat)", "", "spike@mahmoodb.com"),
          "Apache License Version 2.0",
          "https://github.com/springfox/springfox/blob/master/LICENSE",
          new ArrayList<VendorExtension>() {{
              add(new StringVendorExtension("gitRepository", "https://github.com/barialim/mahmood-spikes/tree/master/spring-boot-emb-tomcat"));
          }}
        );
    }
}
