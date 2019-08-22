# Spring Boot User Manager
A web application allowing the management of users in a MySQL database with the scripts provided.
This web applications uses Spring Boot and an embedded Tomcat to run, but the web app is compiled as a war 
so it could easily run on a Tomcat by just deploying the war in the webapps directory of your Tomcat.

On the architecture side, it uses a service which uses itself a repository to be able to interact with the database.
The service itself is used by the RestController, exposing in this example every method of the service.

Unit testing with a H2 database, as well as testing with mocked repositories.