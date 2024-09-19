# Usa la imagen de Amazon Corretto
FROM amazoncorretto:17

# Define un argumento llamado JAR_FILE con el valor por defecto 'target/'
ARG JAR_FILE=target/spring_api-0.0.1.jar

# Copia el archivo JAR desde el host al contenedor
COPY ${JAR_FILE} app_campus.jar

# Expone el puerto 8080 para la comunicación de la aplicación
EXPOSE 8080

# Establece el comando que se ejecutará cuando se inicie el contenedor
ENTRYPOINT ["java","-jar","app_campus.jar"]