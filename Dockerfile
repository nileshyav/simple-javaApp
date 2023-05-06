FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app
COPY target/java-maven-app-1.1.0-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
