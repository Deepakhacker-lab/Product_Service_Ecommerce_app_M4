FROM openjdk:8-jdk-alpine
COPY target/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /product-0.0.1-SNAPSHOT.jar"]