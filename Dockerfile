# Etapa 1
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
    
# Etapa 2
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/spring_api-0.0.1.jar app_campus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app_campus.jar"]