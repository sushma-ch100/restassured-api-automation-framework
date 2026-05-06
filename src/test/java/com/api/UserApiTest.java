package com.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest {

    RequestSpecification request;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";

        request = given()
                .header("x-api-key", "free_user_3DDk3eUAl8mkxIsS9UdI1MkeY6g")
                .header("User-Agent", "RestAssured-Test-Automation")
                .contentType("application/json");
    }

    @Test
    public void getUsersTest() {
        request
        .when()
            .get("/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data.size()", greaterThan(0));
    }

    @Test
    public void getSingleUserTest() {
        request
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", containsString("@reqres.in"));
    }

    @Test
    public void createUserTest() {
        String requestBody = "{ \"name\": \"Sushma\", \"job\": \"QA Engineer\" }";

        request
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Sushma"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue());
    }

    @Test
    public void updateUserTest() {
        String requestBody = "{ \"name\": \"Sushma\", \"job\": \"Senior QA\" }";

        request
            .body(requestBody)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Senior QA"));
    }

    @Test
    public void deleteUserTest() {
        request
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }

    @Test
    public void invalidEndpointTest() {
        request
        .when()
            .get("/api/users/999")
        .then()
            .statusCode(404);
    }
}