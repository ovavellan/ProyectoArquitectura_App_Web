FROM openjdk:17-jdk-alpine

# Copia todos los archivos del directorio actual al contenedor
COPY target/Aeropuerto-MySQL-0.0.1-SNAPSHOT.jar java-app.jar

# Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "java-app.jar"]
