FROM openjdk:11
EXPOSE 8080
WORKDIR /app
COPY target/survey-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "survey-0.0.1-SNAPSHOT.jar" ]