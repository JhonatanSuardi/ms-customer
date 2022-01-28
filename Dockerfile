FROM adoptopenjdk/openjdk11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN apt-get update && apt-get install dos2unix
RUN dos2unix mvnw
RUN ["./mvnw", "package"]
RUN cp target/*.jar ./customer.jar
ENTRYPOINT ["java","-jar","customer.jar"]