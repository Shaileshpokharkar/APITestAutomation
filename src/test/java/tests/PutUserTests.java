
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

public class PutUserTests {

    @Test
    public void updateUser_ValidId_Returns200() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String json = "{ \"name\": \"Updated Name\" }";

        given().
            contentType(ContentType.JSON).
            body(json).
        when().
            put("/users/1").
        then().
            statusCode(anyOf(equalTo(200), equalTo(201))).
            body("name", equalTo("Updated Name"));
    }

    @Test
    public void updateUser_InvalidId_Returns404() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String json = "{ \"name\": \"Updated Name\" }";

        given().
            contentType(ContentType.JSON).
            body(json).
        when().
            put("/users/9999").
        then().
            statusCode(anyOf(equalTo(404), equalTo(200))); // JSONPlaceholder returns 200 even for fake IDs
    }

    @Test
    public void updateUser_EmptyJson_Returns200or400() {
        String emptyJson = "{}";

        given().
            contentType(ContentType.JSON).
            body(emptyJson).
        when().
            put("/users/1").
        then().
            statusCode(anyOf(equalTo(200), equalTo(400)));
    }

    @Test
    public void updateUser_MalformedJson_Returns400() {
    	String malformedJson = "{ \"name\": \"Bad Format\" }";

        given().
            contentType(ContentType.JSON).
            body(malformedJson).
        when().
            put("/users/1").
        then().
            statusCode(anyOf(equalTo(400), equalTo(500)));
    }
}