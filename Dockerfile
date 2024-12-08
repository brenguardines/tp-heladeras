FROM openjdk:17-jdk-slim

WORKDIR /app

COPY config.properties config.properties

COPY target/ejercicio-1.0-SNAPSHOT.jar app.jar

EXPOSE 8000

ENV CONFIG_FILE=config.properties

CMD ["java", "-jar", "app.jar"]
