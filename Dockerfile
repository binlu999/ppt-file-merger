#Tell docker what type of the image
FROM openjdk:8-jdk-alpine
#Add the Built jar into the Docker Container and the folder can be root or temp here it is root dir (ocs-docc-service-event-listener.jar)
ADD target/ocs-docc-service-event-listener.jar ocs-docc-service-event-listener.jar
#Expose the app to port
EXPOSE 80
#Tell the Docker about the falvour of Container
CMD ["java", "-jar", "ocs-docc-service-event-listener.jar"]