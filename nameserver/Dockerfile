FROM maven:3.8.3-openjdk-17
COPY ./target/nameserver-0.0.1-SNAPSHOT.jar . 
EXPOSE 8761 
CMD ["java","-jar","nameserver-0.0.1-SNAPSHOT.jar"] 