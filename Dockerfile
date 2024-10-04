FROM openjdk:17-jdk-slim
ARG JAR_FILE=./labeli-api/target/labeli-0.0.1.jar
COPY ${JAR_FILE} labeli.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "labeli.jar"]