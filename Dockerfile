FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 9001
CMD ["java", "-jar", "target/user-soap-service-1.0.jar"]
