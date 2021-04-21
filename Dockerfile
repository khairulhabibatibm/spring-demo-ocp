ARG RUNTIME_IMAGE=openjdk:11-jdk-slim
FROM ${RUNTIME_IMAGE}
COPY target/demo-ocp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#############################################################################################