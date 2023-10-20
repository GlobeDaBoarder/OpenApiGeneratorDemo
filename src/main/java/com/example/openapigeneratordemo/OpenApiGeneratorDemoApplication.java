package com.example.openapigeneratordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"generated", "org.openapitools.configuration", "com.example.openapigeneratordemo"})
public class OpenApiGeneratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorDemoApplication.class, args);
    }

}
