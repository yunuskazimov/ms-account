FROM openjdk:16-slim-buster

COPY build/libs/ms-account-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar ms-account-0.0.1-SNAPSHOT.jar