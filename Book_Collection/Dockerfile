FROM openjdk
EXPOSE 9550
ADD target/book.jar book.jar
ENTRYPOINT [ "java","-jar","/book.jar" ]