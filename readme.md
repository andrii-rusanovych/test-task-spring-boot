# Spring Boot Application

This is a Spring Boot application that requires a MySQL database. It uses the following dependencies:

- Spring Web
- Thymeleaf
- Spring Security
- Spring Data JPA

## Configuration

To configure the application, follow these steps:

1. Copy the `application.properties.example` file and rename it to `application.properties`.

2. Set the values for the following properties in the `application.properties` file:

<pre>spring.datasource.url=jdbc:mysql://localhost:{<b>$PORT</b>}/{<b>$DATABASE_NAME_IN_LOWER_CASE</b>}?useSSL=false</pre>

<pre>spring.datasource.username=<b>your_mysql_username</b></pre>

<pre>spring.datasource.password=<b>your_mysql_password</b></pre>

Note that the `$PORT` placeholder usually has a default value of `3306`.

3. Create and set the values of the 
**$TEST_TASK_APPLICATION_USER_NAME** 
**TEST_TASK_APPLICATION_USER_PASSWORD** 
system environment variables for the Spring Boot basic authentication default user.

## Running the Application

You can use **Intellij Idea** to run this application using Spring Boot configuration 

To run the application with **maven**, use the following command:
<pre>mvn clean install -DskipTests=true</pre>
then
<pre>mvn spring-boot:run</pre>
This will start the application on the default port 8080. Once the application is running, you can access it at http://localhost:8080/.
