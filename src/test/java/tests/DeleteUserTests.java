
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteUserTests {

    @Test
    public void deleteUser_ValidId_Returns200() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        when().
            delete("/users/1").
        then().
            statusCode(anyOf(equalTo(200), equalTo(204)));
    }

    @Test
    public void deleteUser_InvalidId_Returns200or404() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        when().
            delete("/users/9999").
        then().
            statusCode(anyOf(equalTo(200), equalTo(404)));
    }

    @Test
    public void deleteUser_NonNumericId_Returns404() {
        when().
            delete("/users/xyz").
        then().
            statusCode(404);
    }

    @Test
    public void deleteUser_EmptyPath_Returns404() {
        when().
            delete("/users/").
        then().
            statusCode(anyOf(equalTo(404), equalTo(200)));
    }
}