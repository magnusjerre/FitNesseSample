FROM openjdk
COPY ./web-page/target/*.jar /usr/demo/fitnesse-sample.jar
WORKDIR /usr/demo
CMD ["java", "-jar", "fitnesse-sample.jar"]

