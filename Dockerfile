# Use a base image with Java 21
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file into the container
COPY target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar

# Expose the port on which your Spring Boot application will run
EXPOSE 8080

# Command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
