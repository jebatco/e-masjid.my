FROM openjdk:21

WORKDIR /app

COPY ./target/ajk-api.jar /app/api.jar

EXPOSE 8086

CMD ["sh", "-c", "java -jar api.jar"]