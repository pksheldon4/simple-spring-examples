FROM adoptopenjdk/openjdk11
VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
RUN echo $PATH
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
