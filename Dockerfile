FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD target/ProductManager.jar ProductManager.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]