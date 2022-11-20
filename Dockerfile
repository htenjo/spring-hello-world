FROM openjdk:20-slim-buster

# TODO: Fix user config
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","co.zero.HelloWorldWebApplication"]
