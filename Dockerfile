FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-1.0-SNAPSHOT.jar coffee-order.jar
ENTRYPOINT ["java", "-jar", "coffee-order.jar"]