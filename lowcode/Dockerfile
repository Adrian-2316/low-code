FROM openjdk:17
COPY /target/*.jar /usr/local/lib/lowcode.jar
ADD ../module /usr/local/lib
ENTRYPOINT ["java","-jar","/usr/local/lib/lowcode.jar"]

