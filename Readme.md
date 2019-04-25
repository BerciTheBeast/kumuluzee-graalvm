# KumuluzEE and GraalVM integration

This project is intended to enable and optimize the transformation of KumuluzEE microservices into GraalVM native images.
## Simple Servlet
A GET request on `localhost:8080/servlet` should return the string `Simple Servlet`.

## REST
The data of a single object is of the format:
```java
class RestData {
    String id;
    String prop1;
    String prop2;
}
```

- GET `localhost:8080/v1/rest-data` gets a JSON array with all data instances (empty on startup)
- GET `localhost:8080/v1/rest-data/:id` gets a specific entry via the `:id` parameter
- POST `localhost:8080/v1/rest-data` inserts a new entry
- DELETE `localhost:8080/v1/rest-data/:id` deletes and entry via the `:id` parameter

## Exploded

From the root of the project cd into the exploded directory via `cd exploded`, then run `./build.sh` and `./run.sh`.
`build.sh` should build the project into its exploded version and generate a GraalVM native image.
`run.sh` should run the native image.

After the app starts up, the text `Simple servlet` should be available on `localhost:8080/servlet`, while a simple REST API endpoint should be available on `localhost:8080/v1/rest-data`

## Uber-jar

Same as above, but with `cd uber-jar` at the beginning.

