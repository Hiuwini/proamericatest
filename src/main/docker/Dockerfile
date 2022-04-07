FROM openjdk:11.0.9.1-jdk
ENV TZ=UTC/GMT
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
MAINTAINER hiuwini.17@gmail.com
ADD identitydocument-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]