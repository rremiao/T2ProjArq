FROM maven:3.8.3-openjdk-17 as build
COPY .mvn 
COPY mvnw .
COPY pom.xml .
RUN mvnw clean package
COPY ./target/integrador-0.0.1-SNAPSHOT.jar integrador.jar
EXPOSE 8000
CMD ["java", "-jar", "integrador.jar"]

# FROM maven:3.8.3-openjdk-17 as build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# FROM maven:3.8.3-openjdk-17
# COPY ./target/integrador-0.0.1-SNAPSHOT.jar . 
# EXPOSE 8000
# CMD ["java","-jar","integrador-0.0.1-SNAPSHOT.jar"]