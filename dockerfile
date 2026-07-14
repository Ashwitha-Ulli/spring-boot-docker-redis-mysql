FROM eclipse-temurin:17-jdk
COPY target/DockerPractice-0.0.1-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]