FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["./wait-for-it.sh","mysql:3306","--", "java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


