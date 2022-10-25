# TECHNICAL

##### Technology stack in project:

|Category        |Detail                                 |Version                      |
|----------------|---------------------------------------|-----------------------------|
|Java            |`JDK`                                  |11                           |
|Build tool      |`apache-maven`                         |apache-maven-3.8.6           |
|Framework       |`Spring boot`                          |2.7.4                        |
|                |`mybatis-spring-boot`                  |2.3.3                        |
|Database        |`MySql`.                               |8.0                          |
|Web server      |`Apache Tomcat Embedded`               |9.0.30                       |
|Other plugin    |`springdoc-openapi-ui`                 |1.6.11                       |
|                |`Logback`                              |                             |
|                |`Lombok`                               |1.18.24                      |
|                |`Mybatis generate maven plugin`        |1.4.1                        |
|                |`Mybatis schema migration maven plugin`|1.1.3                        |

##### Maven project structure (Spring boot multi-module architecture):
###### The significant advantage of using this approach is that we may reduce duplication. Splitting your application makes sense for the following:
> - When a certain part of the project needs to have new functionality or bug fixes, you can simply focus on that module and run just the tests for it. Compiling a fraction of all the code and running just the related tests speeds up your work.

> - You can re-use the code from the modules across different projects. Let's assume your project contains some well-written generic-enough code for mail sending. If you later have another project that need mail sending functionality, you can simply re-use your existing module or build upon it (in another module by adding it as a dependency).

> - Easier maintainability on the long run. Maybe now it seems like a small project. In a few months things might look different and then you'll need to do more refactoring to split things into logical units (modules). <br/>

> [Maven Multi Module benefits over simple dependency](https://stackoverflow.com/questions/15559041/maven-multi-module-benefits-over-simple-dependency)

```
.
├── pom.xml
├── framework
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── xx.xx.xx
│           │       └── framework
│           │           └── constant
│           │           └── converter
│           │           └── util
│           │           └── validation
│           └── resources
│               ├── application.properties
│               ├── validationMessages_xx.properties
│               ├── messages.properties
│               └── xx/xx/xx/core
│                   └── config.xml
├── entity
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── xx.xx.xx
│           │       └── entity
│           │           ├── generator
├── dto
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── xx.xx.xx
│           │       └── dto
│           │           ├── function
│           │                   ├── request
│           │                   ├── dxo
│           │                   ├── prm
│           │                   ├── rst
│           │                   ├── response
├── persistence
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── xx.xx.xx
│           │       └── persistence.dao
│           │           ├── generator
│           │                   ├── MonthlyPointMapper.xml
│           │                   ├── MonthlyPointMapper.java
│           │           ├── custom
│           │                   ├── CustomMonthlyPointMapper.xml
│           │                   ├── CustomMonthlyPointMapper.java
├── business
│   ├── pom.xml
│   ├── business-interface
│            ├── pom.xml
│            └── src
│                └── main
│                    ├── java
│                    │   └── xx.xx.xx
│                    │       └── business
│                    │           ├── service
│                    │                     ├── MonthlyPointService.java
│   ├── business-implementation
│            ├── pom.xml
│            └── src
│                └── main
│                    ├── java
│                    │   └── xx.xx.xx
│                    │       └── business
│                    │           ├── service
│                    │                     ├── impl
│                    │                          ├── MonthlyPointService.java
│                └── test
│                    ├── java
│                    │   └── xx.xx.xx
│                    │       └── business
│                    │           ├── service
│                    │                     ├── impl
│                    │                          ├── MonthlyPointServiceTest.java
├── web
│ ├── pom.xml
     ├── api
│        ├── pom.xml
│        └── src
│            └── main
│                ├── java
│                │   └── xx.xx.xx
│                │       └── api
│                │           ├── aspect
│                │           └── config
│                │           └── exception
│                │           └── interceptor
│                │           └── controller
│                │              └── DashBoardController.java
│                │           └── ApiApplication.java
│                └── resources
│                    ├── application.yml
│                    ├── api-messages_[xx].properties
│                    ├── endpoint.yml
│                    └── logback-spring.xml
│                    └── xx/xx/xx/logging/env
│                        └── logback-[env].xml
│            └── test
│                ├── java
│                │   └── xx.xx.xx
│                │       └── api
│                │           └── controller
│                │              └── DashBoardControllerTest.java
│                │           └── ApiApplicationTest.java
├── batch
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── xx.xx.xx
│           │       └── batch
│           │           ├── event
│           │           └── job
│           │           └── util
│           │           └── BatchApplication.java
│           └── resources
│               ├── application.yml
│               ├── logback-spring.xml
│               └── jxx/xx/xx/logging/env
│                   └── logback-[env].xml
├── mybatis-generator
│   ├── pom.xml
│   └── src
│       └── main
│           └── resources
│               ├── generatorConfig.xml
├── mybatis-schema-migration
│   ├── pom.xml
│   └── src
│       └── main
│           └── resources
│               ├── xx/xx/xx/migration
│                   ├── environments
│                       ├── [env].properties
│                   ├── scripts
│                       ├── [timestamp][ddl_description].properties
```

#### Parent - Pom Aggregator
> This module is a maven aggregator that contains all application modules. Also, include all
common dependencies needed by more than one module. Dependencies are defined without version because
this project has defined Spring IO Platform as parent.
#### Project Module - framework
> Offers core functionality that is needed. It doesn't have any dependencies.
#### Project Module - entity
> Module that contains all Entities which are generated from mybatis-generator module. It doesn't have any dependencies.
#### Project Module - dto
> Objects that carries data between layers (controller - service - persistence). Depends of Entity, Framework modules.
#### Project Module - persistence
> This is Persistence layer which is also known as the repository layer. This module is responsible for data persistence and is used by the business layer to access the cache and database. Depends of Framework, Entity, Dto Modules.
#### Project Module - business
> This is The business layer. This module that contains contains all the business logic. It consists of services classes. Depends of Framework, Entity, Dto, Persistence Modules.
#### Project Module - web
> This is the main module of the project. It contains Application.java class, that contains main method, necessary to run Spring Boot applications. It contains all necessary application configuration properties. It contains all rest controllers, api resources. It include Framework, Entity, DTO, Business-Implementation, Persistence modules
#### Project Module - batch
> Module that contains scheduled batch job. It contains Application.java class, that contains main method, necessary to run Spring Boot applications. Depends of Framework, Entity, Dto, Persistence, Business Modules.
#### Project Module - mybatis-generator
> Help Tool for generating Entity and persistence code. It doesn't have any dependencies.
#### Project Module - mybatis-schema-migration
> Module that DDL management. It doesn't have any dependencies.

## DTO Flow
![DTO](assets/images/DTO.png?raw=true)

## How to create schema
[Help article](mybatis-schema-migration/README.md) for you

## How to build
Step 1: cd to root folder <br/>
Step 2: run script
```shell script
$ mvn -pl -mybatis-generator,-mybatis-schema-migration,-batch clean package -DskipTests
``` 

## How to deploy Batch module
[Help article](batch/README.md) for you

## How to deploy API module
- Using embedded container. Running with java tool <br />
Step 1: cd to web/api/target folder <br />
Step 2: Run this command
```sh
    java -jar {APP_FILE}.jar --spring.profiles.active={ENVINROMENT} --PORT={PORT} --LOG_PATH={PATH} 
```

example: 
* Run on develop environment
    ```shell script
    sudo java -jar api-0.0.1-SNAPSHOT.jar --spring.profiles.active=development  --LOG_PATH=/opt/logs/point-management-sys/api
    ``

## Api's description document
```sh
http://localhost:9000/api/v1/swagger-ui/index.html
```

## NOTE
Accept-Language: en, ja or null 







