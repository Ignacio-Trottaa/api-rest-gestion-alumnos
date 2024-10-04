FROM amazoncorretto:17-alpine
WORKDIR /app
COPY target/spring_api-0.0.1.jar app_campus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app_campus.jar"]