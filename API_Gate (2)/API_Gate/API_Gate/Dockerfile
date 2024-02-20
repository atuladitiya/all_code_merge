FROM openjdk
EXPOSE 9008
ADD target/gate.jar gate.jar
ENTRYPOINT [ "java","-jar","/gate.jar" ]