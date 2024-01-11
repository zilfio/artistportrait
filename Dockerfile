# Usa l'immagine base di OpenJDK
FROM openjdk:21-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR della tua applicazione nella directory di lavoro
COPY target/artistportrait-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta sulla quale l'applicazione ascolterà
EXPOSE 8080

# Comando per eseguire l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]