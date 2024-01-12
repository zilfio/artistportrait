FROM openjdk:17-alpine

WORKDIR /app
COPY target/artistportrait-*.jar /app/artistportrait.jar

EXPOSE 8080

CMD ["java", "-jar", "artistportrait.jar"]