FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/C322-Spring2024-lab2-1.0-SNAPSHOT.jar coffee-order.jar
ENTRYPOINT ["java", "-jar", "coffee-order.jar"]