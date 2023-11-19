FROM openjdk:21-jdk-slim as build

LABEL maintainer="yogas.karnik@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/.urandom","-jar", "/app.jar"]