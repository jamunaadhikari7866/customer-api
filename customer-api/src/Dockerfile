FROM eclipse-temurin:17-jdk
ENV JAVA_ORTS=""
COPY target/customer-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT["sh", "-c","java $JAVA_OPTS -jar /app.jar"]