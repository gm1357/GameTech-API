# GameTech-API
API for the [GameTech app](https://github.com/gm1357/GameTech). Uses the [GiantBomb API](https://www.giantbomb.com/api/) to retrieve games informations.

## Requirements

For building and running the application you need:

- [JDK 16](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html)
- [Maven 3](https://maven.apache.org)
- [API key](https://www.giantbomb.com/api/)

## Running the application locally

Firstly you need to create a enviroment variable `GB_API_KEY` with your key.

Then, you can either:

 - Execute the `main` method in the `com.gmachado.gametech.GametechApplication.java` class from your IDE.

 - Or use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Documentation

You can check the API endpoint on `http://localhost:8080/swagger-ui/` when the project is running.
