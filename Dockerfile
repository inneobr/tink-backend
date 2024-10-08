FROM openjdk:17
MAINTAINER root
RUN mkdir api
COPY target/*.jar api/backend.jar
EXPOSE 9100
ENTRYPOINT ["java", "-jar", "/api/backend.jar"]