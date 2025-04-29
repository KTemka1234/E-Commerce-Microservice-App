FROM maven:3-amazoncorretto-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests


FROM amazoncorretto:21-alpine

WORKDIR /app
COPY --from=build /app/target/config-server-*.jar config-server.jar
RUN apk --no-cache add curl
ADD src/main/resources/config config

ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/app/config-server.jar"]

# FROM amazoncorretto:21-alpine

# ARG JAR_FILE=target/config-server-0.0.1-SNAPSHOT.jar
# COPY $JAR_FILE config-server.jar
# RUN apk --no-cache add curl
# ADD src/main/resources/config /home/config/

# ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/config-server.jar"]
