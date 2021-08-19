FROM openjdk:8
EXPOSE 8080
ADD target/ProductManager.jar ProductManager.jar 
ENTRYPOINT ["java","-jar","/ProductManager.jar"]