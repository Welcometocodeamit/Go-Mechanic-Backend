# FROM maven:3.8.5-openjdk-17 as build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /usr/src/app/target/GoMechanicBackend-1.0.0.jar demo.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "demo.jar"]

FROM maven:3.8.5-openjdk-17 as build

# Set the working directory
WORKDIR /usr/src/app

# Copy only the necessary files into the working directory
COPY pom.xml .
COPY src ./src

# Run Maven build
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

# Set the working directory
WORKDIR /usr/src/app

# Copy the JAR file from the build stage
COPY --from=build /usr/src/app/target/GoMechanicBackend-1.0.0.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
