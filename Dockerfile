FROM openjdk:17
VOLUME /tmp
COPY target/*.jar app.jar
<<<<<<< HEAD
ENTRYPOINT ["java","-jar","/app.jar"]
=======
ENTRYPOINT ["java","-jar","/app.jar"]
>>>>>>> a1bc5ed60f505f0ee352f52161a18640975b31ad
