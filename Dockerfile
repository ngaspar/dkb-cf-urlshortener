FROM eclipse-temurin:17-alpine as base
COPY build/libs/urlshortener-0.0.6.PRE-ALPHA.jar ./application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]