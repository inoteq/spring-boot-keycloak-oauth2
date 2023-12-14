# Spring Boot
To run the spring boot application, execute the following command in the root directory of the project:

```bash
./gradlew bootRun
```

The application is then available at http://localhost:8080.
There are three endpoints available:

- [`/`](http://localhost:8080/public) or [`/public`](http://localhost:8080/public): accessible without authentication
- [`/private`](http://localhost:8080/private) - accessible with authentication
- [`/private/user`](http://localhost:8080/private/user) - accessible with authentication and prints the user information

# Keycloak
To create a preconfigured Keycloak container, make sure Docker is running on your system and execute the following command in the root directory of the project:

```bash
docker-compose up --build
```

Keycloak is then available at http://localhost:8081.
The Keycloak container is preconfigured. To log into the administation console, use the following credentials:

- Username: `admin`
- Password: `admin`

A realm specifically configured for this application is imported automatically. You can use the following credentials to log in to the application:

- Username: `john.doe`
- Password: `password`
