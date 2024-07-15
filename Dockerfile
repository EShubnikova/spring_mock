FROM alpine:latest
RUN git clone https://github.com/EShubnikova/spring_mock
RUN cd /spring_mock &&  mvn clean package
RUN java -javaagent:/spring_mock/jolokia/jolokia-agent-jvm-2.0.3-javaagent.jar -jar /spring_mock/target/spring_mock-0.0.1-SNAPSHOT.jar