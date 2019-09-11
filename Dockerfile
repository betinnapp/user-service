FROM maven:3.6.1-jdk-11-slim
EXPOSE 8080
VOLUME /tmp
COPY . .
RUN mvn clean install -DskipTests
ENTRYPOINT ["java","-jar","target/user-service-0.0.1-SNAPSHOT.jar"]