FROM openjdk17-oracle
COPY target/*.jar userService.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "userService.jar"]