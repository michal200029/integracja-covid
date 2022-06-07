FROM amazoncorretto:17-alpine3.13
MAINTAINER ostrowski.opalka
COPY target/Projekt-integracja-0.0.1-SNAPSHOT.jar Projekt-integracja-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Projekt-integracja-0.0.1-SNAPSHOT.jar"]
