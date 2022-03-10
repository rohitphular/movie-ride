FROM maven:3.8.4-openjdk-11

WORKDIR /app

COPY maven/${project.artifactId}.jar api-gateway.jar

CMD ["java", "-jar", "api-gateway.jar"]