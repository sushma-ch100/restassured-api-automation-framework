package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected RequestSpecification request;
    protected Properties properties;

    @BeforeClass
    public void setup() throws IOException {
        properties = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
        properties.load(file);

        RestAssured.baseURI = properties.getProperty("base.url");

        request = given()
                .header("x-api-key", properties.getProperty("api.key"))
                .header("User-Agent", "RestAssured-Test-Automation")
                .contentType("application/json");
    }
}