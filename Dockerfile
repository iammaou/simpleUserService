FROM openjdk:21
MAINTAINER baeldung.com
COPY build/libs/*SNAPSHOT.jar userService.jar
EXPOSE 8080:8081
ENTRYPOINT ["java", "-jar", "userService.jar"]