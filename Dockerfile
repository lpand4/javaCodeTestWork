FROM openjdk:17-jdk-slim

COPY target/*.jar /app/wallet.jar

ENV POSTGRES_DB wallet_system
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password

CMD ["java", "-jar", "/app/wallet.jar"]
