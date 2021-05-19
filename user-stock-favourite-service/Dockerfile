FROM openjdk:11

ADD ./target/user-stock-favourite-service-0.0.1-SNAPSHOT.jar /usr/src/user-stock-favourite-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "user-stock-favourite-service-0.0.1-SNAPSHOT.jar"]