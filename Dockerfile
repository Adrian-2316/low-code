FROM openjdk:17
COPY lowcode/target/*.jar /usr/local/lib/lowcode.jar
ADD module /usr/local/lib/module
WORKDIR /usr/local/lib/module
ENTRYPOINT ["java","-jar","/usr/local/lib/lowcode.jar"]

