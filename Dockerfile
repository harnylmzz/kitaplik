FROM openjdk:17
ARG JAR_FILE=target/*.JAR_FILE
COPY ${JAR_FILE} kitaplik-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/ kitaplik-0.0.1-SNAPSHOT.jar" ]