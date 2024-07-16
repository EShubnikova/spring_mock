FROM alpine/git:latest
WORKDIR /app
RUN git clone https://github.com/EShubnikova/spring_mock

FROM maven
WORKDIR /app
COPY --from=0 /app/spring_mock /app
RUN mvn clean install
 
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=1 /app /app
CMD ["java","-javaagent:/app/jolokia/jolokia-agent-jvm-2.0.3-javaagent.jar=host=0.0.0.0","-jar","/app/target/spring_mock-0.0.1-SNAPSHOT.jar"]

