FROM openjdk:17
MAINTAINER root
RUN mkdir docker
COPY target/*.jar docker/api.jar
EXPOSE 9100
ENTRYPOINT ["java", "-jar", "/docker/api.jar"]