FROM openjdk:11-jre-slim
EXPOSE 8080
VOLUME /tmp
COPY . .
ENTRYPOINT ["java","-jar","target/user-service-0.0.1-SNAPSHOT.jar"]