ARG BUILD_IMAGE=maven:3.5-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

#############################################################################################
###                Stage where Docker is pulling all maven dependencies                   ###
#############################################################################################
FROM ${BUILD_IMAGE} as dependencies

ARG PROXY_SET=false
ARG PROXY_HOST=
ARG PROXY_PORT=

ARG DB_HOST
ARG DB_USER
ARG DB_PASS
ARG DB_NAME
ARG DB_PORT

COPY pom.xml ./

RUN mvn -B dependency:go-offline \
        -DproxySet=${PROXY_SET} \
        -DproxyHost=${PROXY_HOST} \
        -DproxyPort=${PROXY_PORT}
#############################################################################################

#############################################################################################
###              Stage where Docker is building spring boot app using maven               ###
#############################################################################################
FROM dependencies as build

ARG PROXY_SET=false
ARG PROXY_HOST=
ARG PROXY_PORT=

COPY src ./src

ARG ARG_DB_HOST
ARG ARG_DB_USER
ARG ARG_DB_PASS
ARG ARG_DB_NAME
ARG ARG_DB_PORT

ENV DB_HOST=${ARG_DB_HOST}
ENV DB_USER=${ARG_DB_USER}
ENV DB_PASS=${ARG_DB_PASS}
ENV DB_NAME=${ARG_DB_NAME}
ENV DB_PORT=${ARG_DB_PORT}

RUN mvn -B clean package \
        -DproxySet=${PROXY_SET} \
        -DproxyHost=${PROXY_HOST} \
        -DproxyPort=${PROXY_PORT}
#############################################################################################

#############################################################################################
### Stage where Docker is running a java process to run a service built in previous stage ###
#############################################################################################
FROM ${RUNTIME_IMAGE}

COPY --from=build /app/target/demo-ocp-0.0.1-SNAPSHOT.jar /app/service.jar

CMD ["/usr/bin/java", "-jar", "/app/service.jar"]
#############################################################################################