w# Use the OpenJDK image as the base
FROM eclipse-temurin:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Copy your application code into the container
COPY . /app

# Set the working directory
WORKDIR /app

# Build the project using Maven
RUN mvn clean package

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/target/JobApp-0.0.1-SNAPSHOT.jar"]
