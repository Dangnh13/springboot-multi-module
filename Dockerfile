# Create container image
# command: ex) docker build -t mock-service

# build phase
FROM maven:3.8.6-amazoncorretto-11 AS build
WORKDIR /work
# start download dependencies (for caching)
COPY pom.xml .
#RUN mvn verify clean --fail-never
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
# start compile
COPY ./src ./src
RUN mvn clean package -DskipTests=true && mv target/*.jar app.jar

# create app container
FROM amazoncorretto:11-alpine AS runner
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /work
COPY --from=build /work/app.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "./app.jar" ]
