FROM openjdk:17
COPY lowcode/target/*.jar /usr/local/lib/lowcode.jar
ADD module /module
ENTRYPOINT ["java","-jar","/usr/local/lib/lowcode.jar"]

