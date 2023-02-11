package tests.api;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseApiTest {

    @BeforeTest

    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();
    }
}
