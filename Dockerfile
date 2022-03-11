FROM gradle:6.8-jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar

FROM openjdk:11.0.10-jre-slim
COPY --from=builder /home/gradle/src/build/libs/file.transfer-*.jar /usr/jar/file.jar
WORKDIR /usr/jar
EXPOSE 9090
CMD ["java", "-jar", "file.jar"]