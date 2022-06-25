FROM maven:3.8.3-openjdk-17 as build
COPY .mvn 
COPY mvnw .
COPY pom.xml .
RUN mvnw clean package
COPY target/venda-service-0.0.1-SNAPSHOT.jar venda-service.jar
EXPOSE 8003
CMD ["java", "-jar", "venda-service.jar"]

# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# FROM maven:3.8.3-openjdk-17
# COPY ./target/vendaService-0.0.1-SNAPSHOT.jar . 
# EXPOSE 8003
# CMD ["java","-jar","vendaService-0.0.1-SNAPSHOT.jar"]