FROM maven:3.8.3-openjdk-17 as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM maven:3.8.3-openjdk-17
COPY ./target/apiGateway-0.0.1-SNAPSHOT.jar . 
EXPOSE 8008
CMD ["java","-jar","apiGateway-0.0.1-SNAPSHOT.jar"]