FROM openjdk:11
ADD target/restful-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
ENTRYPOINT ["java","-jar","restful-0.0.1-SNAPSHOT.jar"]
