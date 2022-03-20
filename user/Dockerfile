FROM openjdk:17-alpine
MAINTAINER Johannes Dahlgren
COPY user-*.jar user.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/user.jar"]