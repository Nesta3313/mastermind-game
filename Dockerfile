FROM openjdk:17

COPY src/main/java /app
WORKDIR /app

RUN javac Main.java

CMD ["java", "Main"]
