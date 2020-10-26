# Use an official Tomcat 9 runtime as a parent image
#FROM tomcat:9-jre8-alpine
# Updates the distribution and install packages
#RUN apk --no-cache update && apk --no-cache upgrade && \
#    apk --no-cache add --update tzdata
# Set timezone (Alpine)

#RUN cp /usr/share/zoneinfo/Europe/Rome /etc/localtime
# Environments variables
#ENV JAVA_OPTS="-server"

# Cleaning Tomcat
#RUN rm -R /usr/local/tomcat/webapps/* && \
#    mkdir -p /usr/local/tomcat/webapps/ROOT

# Deploy webapps
#RUN mkdir -p /usr/local/tomcat/webapps/client
#ADD chatapplication-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#ADD ChatClientWar.war /usr/local/tomcat/webapps/client

# Don't know why this is mandatory
#RUN cd /usr/local/tomcat/webapps/client && unzip ChatClientWar.war

#EXPOSE 8080

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY chatapplication-0.0.1-SNAPSHOT.war app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
