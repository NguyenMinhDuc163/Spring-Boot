# syntax=docker/dockerfile:1 // tao ra image dung dockerfile version 1

# Ke thua tu image base
FROM openjdk:21-jdk-slim

# Tao thu muc lam viec => tu dong nhay vao app
WORKDIR /app

# copy tu mt vao container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# download cac dependencies khi tao image
RUN ./mvnw dependency:go-offline

# copy source code vao container
COPY src ./src

# build project
CMD ["./mvnw", "spring-boot:run"]