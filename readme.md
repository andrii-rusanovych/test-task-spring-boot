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

`spring.datasource.url=jdbc:mysql://localhost:{**$PORT**}/{**$DATABASE_NAME_IN_LOWER_CASE**}?useSSL=false`

`spring.datasource.username=**your_mysql_username**`

`spring.datasource.password=**your_mysql_password**`

Note that the `$PORT` placeholder usually has a default value of `3306`.

3. Create and set the values of the `$USER_NAME` and `$USER_PASSWORD` environment variables for the Spring Boot basic authentication default user.
