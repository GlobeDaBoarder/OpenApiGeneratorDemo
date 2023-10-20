# OnenAPI Generator Plugin demo for Spring Boot with Maven 

## How to generate code? 

It's very simple! All you need to do is to run the following command in the root folder of the project:
```shell
mvn clean generate-sources
```

That's it! The code will be generated in the `generated` folder.


## About this simple demo

This was a simple project created from [spring initializr](https://start.spring.io/) with Spring web dependency.

The only things added to it were:

1) The `onenapi-generator-maven-plugin` plugin in the `pom.xml` file with the following configuration:
```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>7.0.0</version>

    <configuration>
        <generatorName>spring</generatorName>
        <output>${project.basedir}</output>
        <generateModelTests>false</generateModelTests>
        <generateApiTests>false</generateApiTests>
        <supportingFilesToGenerate>ApiUtil.java,HomeController.java,SpringDocConfiguration.java</supportingFilesToGenerate>
        
        <configOptions>
            <library>spring-boot</library>
            <java8>true</java8>
            <delegatePattern>true</delegatePattern>
            <hideGenerationTimestamp>true</hideGenerationTimestamp>
            <useSpringBoot3>true</useSpringBoot3>
        </configOptions>

        <inputSpec/>
    </configuration>

    <executions>
        <execution>
            <id>generate-pet</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>src/main/resources/openapi.yaml</inputSpec>

                <configOptions>
                    <modelPackage>generated.pet.model</modelPackage>
                    <apiPackage>generated.pet.api</apiPackage>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Read mode about configuration options for OpenAPI generator plugin here:
https://openapi-generator.tech/docs/generators/spring/

2) The `openapi.yaml` file in the `src/main/resources` folder with the following content:
```yaml
openapi: 3.0.3
info:
  title: Pet API
  description: Pet API
  version: 1.0.0
  contact:
    name: Gleb
    email: glebivashyn@gmail.com
  license:
    name: Open Source
servers:
  - url: 'http://localhost:8099'

paths:
  /pets:
    get:
      summary: Get all pets
      operationId: getAllPets
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Pet'
    post:
      summary: Create a pet
      operationId: createPet
      requestBody:
        description: Pet object that needs to be added to the store
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Pet'
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Pet'
components:
  schemas:
    Pet:
      type: object
      properties:
        name:
          type: string
        breed:
          type: string
        age:
          type: integer
          format: int32

```

3) SpringDoc dependencies in the `pom.xml` file for OpenAPI documentation to be generated:
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>

<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>jackson-databind-nullable</artifactId>
    <version>0.2.6</version>
</dependency>
```

4) Added @ComponentScan to Spring boot application class:
```java 
@SpringBootApplication
@ComponentScan(basePackages = {"generated", "org.openapitools.configuration"})
public class OpenApiGeneratorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiGeneratorDemoApplication.class, args);
    }

}
```

