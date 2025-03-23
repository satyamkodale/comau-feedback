# Stage 1: Build the application
FROM gradle:7.5-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy necessary files for dependency resolution
COPY build.gradle settings.gradle gradlew gradlew.bat ./
COPY gradle gradle

# Download dependencies
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build the application
RUN ./gradlew build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Define the artifact file name
ARG JAR_FILE=comaufeedback-1.0.0.jar  # Update version if needed

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/${JAR_FILE} app.jar

# Expose the application's port
EXPOSE 1911  # Change if your app runs on a different port

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
