FROM openjdk:17-jdk-alpine

# Copia todos los archivos del directorio actual al contenedor
COPY target/Aeropuerto-Mongo-0.0.1-SNAPSHOT.jar java-app-mongo.jar

# Comando para ejecutar la aplicación al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "java-app-mongo.jar"]