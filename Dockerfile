FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build ./build/target/*.jar ./convidados.jar
ENTRYPOINT java -jar convidados.jar