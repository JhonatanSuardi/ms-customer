FROM adoptopenjdk/openjdk11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN apt-get update && apt-get install dos2unix
RUN dos2unix mvnw
RUN ["./mvnw", "package"]
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} customer.jar
ENTRYPOINT ["java","-jar","customer.jar"]