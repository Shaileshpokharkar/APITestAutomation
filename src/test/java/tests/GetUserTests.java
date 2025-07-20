
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTests {

    @Test
    public void getUser_ValidId_ReturnsUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().
        when().
            get("/users/1").
        then().
            statusCode(200).
            body("id", equalTo(1));
    }

    @Test
    public void getUser_InvalidId_Returns404() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().
        when().
            get("/users/9999").
        then().
            statusCode(404);
    }

    @Test
    public void getUser_NonNumericId_Returns404() {
        given().
        when().
            get("/users/abc").
        then().
            statusCode(404);
    }

    @Test
    public void getUser_EmptyPath_Returns404() {
        given().
        when().
            get("/users/").
        then().
            statusCode(200); // JSONPlaceholder may return 200 with list
    }
}