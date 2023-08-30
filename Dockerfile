FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kitaplikDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/ lib-0.0.1-SNAPSHOT.jar" ]

