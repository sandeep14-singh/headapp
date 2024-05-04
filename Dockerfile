FROM openjdk:21

WORKDIR /usr/src/appb
COPY ./target/headApp-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar" ]