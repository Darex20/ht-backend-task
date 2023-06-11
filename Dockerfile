# Use a base image with Java Corretto 17
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by your Spring Boot application
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Set the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]


