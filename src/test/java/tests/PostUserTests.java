
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class PostUserTests {

    @Test
    public void createUser_ValidData_Returns201() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String json = "{ \"name\": \"John Doe\", \"username\": \"johndoe\", \"email\": \"john@example.com\" }";

        given().
            contentType(ContentType.JSON).
            body(json).
        when().
            post("/users").
        then().
            statusCode(201).
            body("name", equalTo("John Doe"));
    }

    @Test
    public void createUser_MissingBody_Returns400() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().
            contentType(ContentType.JSON).
        when().
            post("/users").
        then().
            statusCode(anyOf(equalTo(400), equalTo(500))); // Behavior may vary
    }

    @Test
    public void createUser_InvalidJson_Returns400() {
        String invalidJson = "{ name: John }"; // missing quotes

        given().
            contentType(ContentType.JSON).
            body(invalidJson).
        when().
            post("/users").
        then().
            statusCode(anyOf(equalTo(400), equalTo(500)));
    }

    @Test
    public void createUser_EmptyJson_Returns400or201() {
        String emptyJson = "{}";

        given().
            contentType(ContentType.JSON).
            body(emptyJson).
        when().
            post("/users").
        then().
            statusCode(anyOf(equalTo(400), equalTo(201)));
    }
}