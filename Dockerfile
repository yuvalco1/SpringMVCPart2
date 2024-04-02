FROM openjdk:21
COPY target/SpringMVCPart2-1.0-SNAPSHOT.war /SpringMVCPart2-1.0-SNAPSHOT.war

EXPOSE 8090


## Add a sleep command to delay execution
ENTRYPOINT ["java" ,"-jar" , "/SpringMVCPart2-1.0-SNAPSHOT.war"]
