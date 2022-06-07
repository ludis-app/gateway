#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /opt/
COPY src /opt/src/
WORKDIR /opt
RUN mvn -f /opt/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /opt/target/gateway-0.0.1-SNAPSHOT.jar /usr/local/lib/gateway.jar
ENV PORT 8000
EXPOSE 8000
ENTRYPOINT ["java","-jar","/usr/local/lib/gateway.jar"]