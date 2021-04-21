ARG RUNTIME_IMAGE=openjdk:11-jdk-slim
FROM ${RUNTIME_IMAGE}

ARG DB_HOST
ARG DB_NAME
ARG DB_PORT
ARG DB_USER
ARG DB_PASS

ENV DB_HOST=${DB_HOST}}
ENV DB_NAME=${DB_NAME}
ENV DB_PORT=${DB_PORT}
ENV DB_USER=${DB_USER}
ENV DB_PASS=${DB_PASS}

COPY target/demo-ocp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#############################################################################################