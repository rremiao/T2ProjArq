FROM maven:3.8.3-openjdk-17 as build
COPY .mvn 
COPY mvnw .
COPY pom.xml .
RUN mvnw clean package
COPY target/nameserver-0.0.1-SNAPSHOT.jar nameserver.jar
EXPOSE 8761 
CMD ["java", "-jar", "nameserver.jar"]

# FROM maven:3.8.3-openjdk-17 as build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# FROM maven:3.8.3-openjdk-17
# COPY ./target/nameserver-0.0.1-SNAPSHOT.jar . 
# EXPOSE 8761 
# CMD ["java","-jar","nameserver-0.0.1-SNAPSHOT.jar"] 