FROM maven:3.8.6-jdk-11
WORKDIR /app

# Copy the dependency specifications
COPY pom.xml pom.xml
COPY framework/pom.xml framework/pom.xml
COPY entity/pom.xml entity/pom.xml
COPY dto/pom.xml dto/pom.xml
COPY persistence/pom.xml persistence/pom.xml
COPY business/pom.xml business/pom.xml
COPY business/business-interface/pom.xml business/business-interface/pom.xml
COPY business/business-implementation/pom.xml business/business-implementation/pom.xml
COPY web/pom.xml web/pom.xml
COPY web/api/pom.xml web/api/pom.xml
COPY mybatis-generator/pom.xml mybatis-generator/pom.xml
COPY mybatis-schema-migration/pom.xml mybatis-schema-migration/pom.xml
COPY batch/pom.xml batch/pom.xml

RUN mvn -am -pl framework,entity dependency:resolve

# Copy full sources for `api` module
COPY framework framework
COPY entity entity
COPY dto dto
COPY persistence persistence
COPY business business
COPY web web

RUN mvn -am -pl web/api clean package -DskipTests

EXPOSE 9000
CMD ["java", "-jar", "./web/api/target/api-0.0.1-SNAPSHOT.jar"]
