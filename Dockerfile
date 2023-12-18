FROM gradle:8.2.1 AS gradle_build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test #skipping test and no daemon means it will exit once the build finishes

FROM openjdk:17
EXPOSE 8080
RUN mkdir /app
COPY --from=gradle_build  /home/gradle/src/build/libs/*.jar /app/app.jar
ENV HOST_URL=host.docker.internal
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]