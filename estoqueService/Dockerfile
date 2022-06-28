FROM maven:3.8.3-openjdk-17 as build
COPY src /home/app/src
COPY pom.xml /pom.xml
RUN mvn -f pom.xml clean package

FROM maven:3.8.3-openjdk-17
COPY ./target/estoqueService-0.0.1-SNAPSHOT.jar . 
EXPOSE 8002
CMD ["java","-jar","estoqueService-0.0.1-SNAPSHOT.jar"]