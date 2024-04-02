FROM maven
COPY . .

EXPOSE 8090


## Add a sleep command to delay execution
ENTRYPOINT ["mvn", "jetty:run"]
