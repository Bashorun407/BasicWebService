FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/basicweb-0.01-SNAPSHOT.jar basicweb.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "basicweb.jar"]
