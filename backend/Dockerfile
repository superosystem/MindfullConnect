FROM eclipse-temurin:17

RUN mkdir /app

COPY --from=build /build/libs/*.jar /app/server.jar

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "/app/server.jar"]