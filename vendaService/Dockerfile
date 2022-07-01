FROM maven:3.8.3-openjdk-17 as build
WORKDIR /usr/src/app
COPY ./pom.xml .
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:go-offline
COPY ./ .
RUN mvn -B -f ./pom.xml -s /usr/share/maven/ref/settings-docker.xml package -DskipTests -Dmaven.test.skip=true
EXPOSE 8761
CMD ["java","-jar","vendaService-0.0.1-SNAPSHOT.jar"]