FROM maven:3-amazoncorretto-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests


FROM amazoncorretto:21-alpine

WORKDIR /app
COPY --from=build /app/target/discovery-*.jar discovery.jar
RUN apk --no-cache add curl

ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/app/discovery.jar"]

# FROM amazoncorretto:21-alpine

# ARG JAR_FILE=target/discovery-0.0.1-SNAPSHOT.jar
# COPY $JAR_FILE discovery.jar
# RUN apk --no-cache add curl

# ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/discovery.jar"]
