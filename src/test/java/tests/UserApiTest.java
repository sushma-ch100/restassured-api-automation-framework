package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    public void getUsersTest() {
        request
            .log().all()
        .when()
            .get("/api/users?page=2")
        .then()
            .log().all()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data.size()", greaterThan(0));
    }

    @Test
    public void getSingleUserTest() {
        request
            .log().all()
        .when()
            .get("/api/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", containsString("@reqres.in"))
            .body("data.first_name", notNullValue());
    }

    @Test
    public void createUserTest() {
        String requestBody = "{ \"name\": \"Sushma\", \"job\": \"QA Engineer\" }";

        request
            .log().all()
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("name", equalTo("Sushma"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue());
    }

    @Test
    public void updateUserTest() {
        String requestBody = "{ \"name\": \"Sushma\", \"job\": \"Senior QA\" }";

        request
            .log().all()
            .body(requestBody)
        .when()
            .put("/api/users/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("job", equalTo("Senior QA"));
    }

    @Test
    public void deleteUserTest() {
        request
            .log().all()
        .when()
            .delete("/api/users/2")
        .then()
            .log().all()
            .statusCode(204);
    }

    @Test
    public void invalidEndpointTest() {
        request
            .log().all()
        .when()
            .get("/api/users/999")
        .then()
            .log().all()
            .statusCode(404);
    }
}