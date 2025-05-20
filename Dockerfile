# Use Eclipse Temurin JDK 21 (LTS)
FROM eclipse-temurin:21

# Set workdir
WORKDIR /app

# Copy your JAR into the image
COPY build/libs/taiyuken-backend-1.0-SNAPSHOT.jar app.jar

# Expose port if necessary
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]