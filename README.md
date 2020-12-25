##Survey application

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.6.3](https://maven.apache.org)
- [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)

## Configuration of properties file

#### Running with MySQL database in development make sure to have a running server.
- Create application user and database schema.

  ```mysql> create database db_example; -- Creates the new database
   mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
   mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
    ```
- set these properties for new user in application.properties file 
    
    ```
       spring.jpa.hibernate.ddl-auto=update
       spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
       spring.datasource.username=springuser
       spring.datasource.password=ThePassword
  ```
    
- H2 database, to use H2 just uncomment H2 configuration and comment MySQL.

## Application properties

![application.properties](/properties_file.PNG)
 
## ER diagram

![Application ER Diagram](/Survey_ER_Diagram.PNG)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.horvat.dragutin.survey.SurveyApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
##URL for a documentation and H2 in memory database
 - http://localhost:8080/swagger-ui.html
 - http://localhost:8080/h2-console/

 
 ## Copyright
 
 Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.