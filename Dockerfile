FROM amazoncorretto:17
COPY build/libs/*.jar app.jar
ENTRYPOINT [ \
    "java", \
    "-jar", \
    "app.jar"]