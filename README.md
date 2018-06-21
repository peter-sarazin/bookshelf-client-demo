# bookshelf-client-demo
Demo of a web client application created with Spring Boot, Thymeleaf, and Bootstrap.

In order to run this you will need to get and build the bookshelf-service-demo first and run it as a Spring Boot App.

Then after you have the service up and running, you will need to build the web client application with maven run it as a Spring Boot App.

There are several ways to run an application as a Spring Boot App:

1. In Eclipse, you can right-click the project and Choose Run As -> Spring Boot App.
2. You can also run the jar file from the command line.

Example:
```sh
java -jar books-client-thymeleaf-0.0.1-SNAPSHOT.jar
```

The default port that this application runs on is 8080.

You can change the default port number in /src/main/resources/application.properties and you can also override the port number on the commandline at startup.  Example:

```sh
java -jar books-client-thymeleaf-0.0.1-SNAPSHOT.jar --server.port=8082
```
