FROM maven:3-amazoncorretto-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests


FROM amazoncorretto:21-alpine

WORKDIR /app
COPY --from=build /app/target/payment-*.jar payment.jar
RUN apk --no-cache add curl

ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/app/payment.jar"]

# FROM amazoncorretto:21-alpine

# ARG JAR_FILE=target/payment-0.0.1-SNAPSHOT.jar
# COPY $JAR_FILE payment.jar
# RUN apk --no-cache add curl

# ENTRYPOINT ["java", "-jar", "-Dspring.output.ansi.enabled=ALWAYS", "/payment.jar"]
