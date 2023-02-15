package tests.api;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresApiTest {

    @Test
    public void simpleStepByStepApiTest() {
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in/";

        //Setup endpoint
        int userId = 2;
        String endpoint = "/api/users/" + userId;

        // Setup request Object
        RequestSpecification httpRequest = given();

        //Setup response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

        //Get Response Body
        System.out.println(response.getBody().asPrettyString());

    }

    @Test
    public void simpleShortApiTest() {
        //Setup RestAssured
        RestAssured.baseURI = "https://reqres.in/";

        //Setup endpoint
        int userId = 2;
        String endpoint = "/api/users/" + userId;

        given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

}
