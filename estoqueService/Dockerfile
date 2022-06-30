FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean -e -B package

FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY --from=build /app/target/estoqueService-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
CMD ["java","-jar","estoqueService-0.0.1-SNAPSHOT.jar"]