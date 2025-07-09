FROM eclipse-temurin:23-jdk AS builder

WORKDIR /el_noticioso_backend-0.0.1-SNAPSHOT

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:23-jre

WORKDIR /el_noticioso_backend-0.0.1-SNAPSHOT

COPY --from=builder /el_noticioso_backend-0.0.1-SNAPSHOT/target/*.jar el_noticioso_backend-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","el_noticioso_backend-0.0.1-SNAPSHOT.jar"]
