FROM maven:3.8.6-jdk-11

WORKDIR /app
COPY /web/api/target/api-0.0.1-SNAPSHOT.jar .
EXPOSE 9000
CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]