FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn clean install -Dmaven.test.skip=true

FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY --from=build /app/target/produtoservice-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
CMD ["java","-jar","produtoservice-0.0.1-SNAPSHOT.jar"]